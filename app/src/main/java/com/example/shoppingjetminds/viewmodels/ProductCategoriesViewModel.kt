package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.use_cases.product_categories.GetProductCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface ProductCategoriesUiState {
    object Loading: ProductCategoriesUiState
    data class Success(val categories: List<ProductCategoriesResponse>): ProductCategoriesUiState
    data class Error(val message: String): ProductCategoriesUiState
}

data class HomeScreenProductCategoriesUiState(
    val categoriesUiState: ProductCategoriesUiState
)

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase
): ViewModel() {

    private var _categoriesState = MutableStateFlow(HomeScreenProductCategoriesUiState(ProductCategoriesUiState.Loading))
    val categoriesState = _categoriesState.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
           getProductCategoriesUseCase.invoke().collect { categoriesResult ->
                val categoriesUiStateResult = when (categoriesResult) {
                    ServiceResult.Loading -> ProductCategoriesUiState.Loading
                    is ServiceResult.Success -> ProductCategoriesUiState.Success(categories = categoriesResult.data)
                    is ServiceResult.Error -> ProductCategoriesUiState.Error(message = categoriesResult.throwable?.message!!)
                }

               _categoriesState.value = HomeScreenProductCategoriesUiState(categoriesUiStateResult)
            }
        }
    }
}
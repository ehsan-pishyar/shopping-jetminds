package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.use_cases.product_categories.GetProductCategoriesUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoryDetailsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase,
    private val getProductCategoryDetailsUseCase: GetProductCategoryDetailsUseCase
): ViewModel() {

    var categoriesState by mutableStateOf(ProductCategoriesUiState())
    var categoryState by mutableStateOf(ProductCategoryUiState())

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            categoriesState = categoriesState.copy(loading = true)
            getProductCategoriesUseCase.invoke().collect { categories ->
                when(categories) {
                    is ServiceResult.Success -> {
                        categoriesState = categoriesState.copy(
                            loading = false,
                            success = true,
                            error = null,
                            categories = categories.data
                        )
                    }
                    is ServiceResult.Error -> {
                        categoriesState = categoriesState.copy(
                            loading = false,
                            success = false,
                            error = categories.error,
                            categories = null
                        )
                    }
                    else -> Unit
                }
            }
        }
    }
}

data class ProductCategoriesUiState(
    val loading: Boolean = true,
    val success: Boolean = false,
    val error: String? = "",
    val categories: List<ProductCategoriesResponse>? = emptyList()
)

data class ProductCategoryUiState(
    val loading: Boolean = true,
    val success: Boolean = false,
    val error: String? = "",
    val category: ProductCategoriesResponse? = null
)
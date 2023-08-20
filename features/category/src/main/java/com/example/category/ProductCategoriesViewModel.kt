package com.example.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.product_categories.GetProductCategoriesUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoryDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase,
    private val getProductCategoryDetailsUseCase: GetProductCategoryDetailsUseCase
): ViewModel() {

    private var _categoriesState = MutableStateFlow(MainProductCategoriesUiState(ProductCategoriesUiState.Loading))
    val categoriesState = _categoriesState.asStateFlow()

    private var _categoryDetailsState = MutableStateFlow(MainProductCategoryDetailsUiState(ProductCategoryDetailsUiState.Loading))
    val categoryDetailsState = _categoryDetailsState.asStateFlow()

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

               _categoriesState.value = MainProductCategoriesUiState(categoriesUiStateResult)
            }
        }
    }

    fun getCategoryDetails(categoryId: Int) {
        viewModelScope.launch {
            getProductCategoryDetailsUseCase.invoke(categoryId = categoryId).collect { categoryDetailsResult ->
                val categoryDetailsUiStateResult = when (categoryDetailsResult) {
                    ServiceResult.Loading -> ProductCategoryDetailsUiState.Loading
                    is ServiceResult.Success -> ProductCategoryDetailsUiState.Success(
                        categoryDetails = categoryDetailsResult.data
                    )
                    is ServiceResult.Error -> ProductCategoryDetailsUiState.Error(
                        message = categoryDetailsResult.throwable?.message!!
                    )
                }
                _categoryDetailsState.value = MainProductCategoryDetailsUiState(
                    categoryDetailsUiState = categoryDetailsUiStateResult
                )
            }
        }
    }
}
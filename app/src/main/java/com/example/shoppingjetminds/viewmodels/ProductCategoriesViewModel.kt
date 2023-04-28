package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.*
import com.example.domain.utils.Result

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
): ViewModel() {

    private val _state = MutableStateFlow(HomeCategoriesUIState(CategoriesUiState.Loading))
    val state = _state.asStateFlow()

    fun getCategories() {
        viewModelScope.launch {
            productCategoriesRepository.getProductCategories().asResult()
                .collect { result ->
                    val categoriesUiState = when (result) {
                        is Result.Success -> {
                            println("ViewModel: Success")
                            CategoriesUiState.Success(result.data)
                        }
                        is Result.Loading -> {
                            println("ViewModel: Loading")
                            CategoriesUiState.Loading
                        }
                        is Result.Error -> {
                            println("ViewModel: Error")
                            CategoriesUiState.Error
                        }
                    }

                    _state.value = HomeCategoriesUIState(categoriesUiState)
                }
        }
    }
}

sealed interface CategoriesUiState {
    data class Success(val categories: List<ProductCategoriesResponse>) : CategoriesUiState
    object Error : CategoriesUiState
    object Loading : CategoriesUiState
}

data class HomeCategoriesUIState(
    val categories: CategoriesUiState
)
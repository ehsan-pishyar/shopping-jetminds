package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductsResponse
import com.example.domain.use_cases.products.GetNewestProductsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val newestProductList: NewestProductUiState
)

sealed interface NewestProductUiState {
    data class Success(val data: List<ProductsResponse>): NewestProductUiState
    data class Error(val throwable: Throwable? = null): NewestProductUiState
    object Loading: NewestProductUiState
}

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getNewestProductsUseCase: GetNewestProductsUseCase
): ViewModel() {

    private var _newestUiState = MutableStateFlow(HomeUiState(NewestProductUiState.Loading))
    val newestUiState = _newestUiState.asStateFlow()

    init {
        getNewestProducts()
    }

    private fun getNewestProducts() =
        viewModelScope.launch {
            getNewestProductsUseCase.invoke().collect { newestResult ->
                val newestUiStateResult = when (newestResult) {
                    ServiceResult.Loading -> NewestProductUiState.Loading
                    is ServiceResult.Success -> NewestProductUiState.Success(newestResult.data)
                    is ServiceResult.Error -> NewestProductUiState.Error(newestResult.throwable?.cause)
                }
                _newestUiState.value = HomeUiState(newestProductList = newestUiStateResult)
            }
        }
}


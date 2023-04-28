package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.domain.models.ProductsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(

): ViewModel() {

}

data class HomeUiState(
    val onSaleProducts: OnSaleProductsUiState,
    val popularProducts: PopularProductsUiState,
    val topSalesProducts: TopSalesProductsUiState,
    val newestProducts: NewestProductsUiState,
    val topRatedProducts: TopRatedProductsUiState,
    val isRefreshing: Boolean,
    val isError: Boolean
)
@Immutable
sealed interface OnSaleProductsUiState {
    data class Success(val data: List<ProductsResponse>): OnSaleProductsUiState
    object Error: OnSaleProductsUiState
    object Loading: OnSaleProductsUiState
}

@Immutable
sealed interface PopularProductsUiState {
    data class Success(val data: List<ProductsResponse>): PopularProductsUiState
    object Error: PopularProductsUiState
    object Loading: PopularProductsUiState
}

@Immutable
sealed interface TopSalesProductsUiState {
    data class Success(val data: List<ProductsResponse>): TopSalesProductsUiState
    object Error: TopSalesProductsUiState
    object Loading: TopSalesProductsUiState
}

@Immutable
sealed interface NewestProductsUiState {
    data class Success(val data: List<ProductsResponse>): NewestProductsUiState
    object Error: NewestProductsUiState
    object Loading: NewestProductsUiState
}

@Immutable
sealed interface TopRatedProductsUiState {
    data class Success(val data: List<ProductsResponse>): TopRatedProductsUiState
    object Error: TopRatedProductsUiState
    object Loading: TopRatedProductsUiState
}
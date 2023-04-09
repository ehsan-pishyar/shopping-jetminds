package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductsResponse
import com.example.domain.use_cases.products.*
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val getProductsByAttrIdUseCase: GetProductsByAttrIdUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
    private val getProductsByTagIdUseCase: GetProductsByTagIdUseCase,
    private val getOnSaleProductsForHomeUseCase: GetOnSaleProductsForHomeUseCase,
    private val getPopularProductsForHomeUseCase: GetPopularProductsForHomeUseCase,
    private val getTopSalesProductsForHomeUseCase: GetTopSalesProductsForHomeUseCase,
    private val getNewestProductsForHomeUseCase: GetNewestProductsForHomeUseCase,
    private val getTopRatedProductsForHomeUseCase: GetTopRatedProductsForHomeUseCase
): ViewModel() {

    var onSaleState by mutableStateOf(ProductsUiState())
    var popularState by mutableStateOf(ProductsUiState())
    var topSalesState by mutableStateOf(ProductsUiState())
    var newestState by mutableStateOf(ProductsUiState())
    var topRatedState by mutableStateOf(ProductsUiState())

    init {
        getOnSaleProductsForHome()
        getPopularProductsForHome()
        getTopSalesProductsForHome()
        getNewestProductsForHome()
        getTopRatedProductsForHome()
    }

    private fun getOnSaleProductsForHome() {
        viewModelScope.launch {
            getOnSaleProductsForHomeUseCase.invoke().collect { onSaleProducts ->
                when(onSaleProducts) {
                    is ServiceResult.Loading -> {
                        onSaleState = onSaleState.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        onSaleState = onSaleState.copy(
                            loading = false,
                            success = true,
                            products = onSaleProducts.data
                        )
                    }
                    is ServiceResult.Error -> {
                        onSaleState = onSaleState.copy(
                            loading = false,
                            error = onSaleProducts.error
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun getPopularProductsForHome() {
        viewModelScope.launch {
            getPopularProductsForHomeUseCase.invoke().collect { popularProducts ->
                when(popularProducts) {
                    is ServiceResult.Loading -> {
                        popularState = popularState.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        popularState = popularState.copy(
                            loading = false,
                            success = true,
                            products = popularProducts.data
                        )
                    }
                    is ServiceResult.Error -> {
                        popularState = popularState.copy(
                            loading = false,
                            error = popularProducts.error
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun getTopSalesProductsForHome() {
        viewModelScope.launch {
            getTopSalesProductsForHomeUseCase.invoke().collect { topSalesProducts ->
                when(topSalesProducts) {
                    is ServiceResult.Loading -> {
                        topSalesState = topSalesState.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        topSalesState = topSalesState.copy(
                            loading = false,
                            success = true,
                            products = topSalesProducts.data
                        )
                    }
                    is ServiceResult.Error -> {
                        topSalesState = topSalesState.copy(
                            loading = false,
                            error = topSalesProducts.error
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun getNewestProductsForHome() {
        viewModelScope.launch {
            getNewestProductsForHomeUseCase.invoke().collect { newestProducts ->
                when(newestProducts) {
                    is ServiceResult.Loading -> {
                        newestState = newestState.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        newestState = newestState.copy(
                            loading = false,
                            success = true,
                            products = newestProducts.data
                        )
                    }
                    is ServiceResult.Error -> {
                        newestState = newestState.copy(
                            loading = false,
                            error = newestProducts.error
                        )
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun getTopRatedProductsForHome() {
        viewModelScope.launch {
            getTopRatedProductsForHomeUseCase.invoke().collect { topRatedProducts ->
                when(topRatedProducts) {
                    is ServiceResult.Loading -> {
                        topRatedState = topRatedState.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        topRatedState = topRatedState.copy(
                            loading = false,
                            success = true,
                            products = topRatedProducts.data
                        )
                    }
                    is ServiceResult.Error -> {
                        topRatedState = topRatedState.copy(
                            loading = false,
                            error = topRatedProducts.error
                        )
                    }
                    else -> Unit
                }
            }
        }
    }
}

data class ProductsUiState(
    val loading: Boolean = true,
    val success: Boolean = false,
    val error: String? = null,
    val products: List<ProductsResponse>? = null
)
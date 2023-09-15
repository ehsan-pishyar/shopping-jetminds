package com.example.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.products.GetHighestPriceProductsUseCase
import com.example.domain.use_cases.products.GetLowestPriceProductsUseCase
import com.example.domain.use_cases.products.GetNewestProductsUseCase
import com.example.domain.use_cases.products.GetOnSaleProductsUseCase
import com.example.domain.use_cases.products.GetPopularProductsUseCase
import com.example.domain.use_cases.products.GetProductsByCategoryIdUseCase
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.use_cases.products.GetTopRatedProductsUseCase
import com.example.domain.use_cases.products.GetTopSalesProductsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
    private val getNewestProductsUseCase: GetNewestProductsUseCase,
    private val getPopularProductsUseCase: GetPopularProductsUseCase,
    private val getOnSaleProductsUseCase: GetOnSaleProductsUseCase,
    private val getTopRatedProductsUseCase: GetTopRatedProductsUseCase,
    private val getTopSalesProductsUseCase: GetTopSalesProductsUseCase,
    private val getLowestPriceProductsUseCase: GetLowestPriceProductsUseCase,
    private val getHighestPriceProductsUseCase: GetHighestPriceProductsUseCase
): ViewModel() {

    private var _shopUiState = MutableStateFlow(MainShopProductsUiState(ShopProductsUiState.Loading))
    val shopUiState = _shopUiState.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts(
        categoryId: Int? = null
    ) {
       viewModelScope.launch {
           getProductsUseCase.invoke(categoryId = categoryId).collect { productResults ->
               val shopProductsUiStateResult = when (productResults) {
                   ServiceResult.Loading -> ShopProductsUiState.Loading
                   is ServiceResult.Success -> ShopProductsUiState.Success(
                       products = productResults.data
                   )
                   is ServiceResult.Error -> ShopProductsUiState.Error(
                       throwable = productResults.throwable!!
                   )
               }
               _shopUiState.value = MainShopProductsUiState(
                   shopProductsUiState = shopProductsUiStateResult
               )
           }
//           getProductsUseCase.invoke().collect { productResults ->
//               val shopProductsUiStateResult = when (productResults) {
//                   ServiceResult.Loading -> ShopProductsUiState.Loading
//                   is ServiceResult.Success -> ShopProductsUiState.Success(
//                       products = productResults.data
//                   )
//                   is ServiceResult.Error -> ShopProductsUiState.Error(
//                       throwable = productResults.throwable!!
//                   )
//               }
//               _shopUiState.value = MainShopProductsUiState(
//                   shopProductsUiState = shopProductsUiStateResult
//               )
//           }
       }
    }

    fun getNewestProducts() {
        viewModelScope.launch {
            getNewestProductsUseCase.invoke().collect { productResults ->
                val newestProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = newestProductsUiStateResult
                )
            }
        }
    }

    fun getPopularProducts() {
        viewModelScope.launch {
            getPopularProductsUseCase.invoke().collect { productResults ->
                val popularProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = popularProductsUiStateResult
                )
            }
        }
    }

    fun getOnSaleProducts() {
        viewModelScope.launch {
            getOnSaleProductsUseCase.invoke().collect { productResults ->
                val onSaleProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = onSaleProductsUiStateResult
                )
            }
        }
    }

    fun getTopRatedProducts() {
        viewModelScope.launch {
            getTopRatedProductsUseCase.invoke().collect { productResults ->
                val topRatedProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = topRatedProductsUiStateResult
                )
            }
        }
    }

    fun getTopSalesProducts() {
        viewModelScope.launch {
            getTopSalesProductsUseCase.invoke().collect { productResults ->
                val topSaleProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = topSaleProductsUiStateResult
                )
            }
        }
    }

    fun getLowestPriceProducts() {
        viewModelScope.launch {
            getLowestPriceProductsUseCase.invoke().collect { productResults ->
                val lowestPriceProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = lowestPriceProductsUiStateResult
                )
            }
        }
    }

    fun getHighestPriceProducts() {
        viewModelScope.launch {
            getHighestPriceProductsUseCase.invoke().collect { productResults ->
                val highestPriceProductsUiStateResult = when (productResults) {
                    ServiceResult.Loading -> ShopProductsUiState.Loading
                    is ServiceResult.Success -> ShopProductsUiState.Success(
                        products = productResults.data
                    )
                    is ServiceResult.Error -> ShopProductsUiState.Error(
                        throwable = productResults.throwable!!
                    )
                }
                _shopUiState.value = MainShopProductsUiState(
                    shopProductsUiState = highestPriceProductsUiStateResult
                )
            }
        }
    }
}
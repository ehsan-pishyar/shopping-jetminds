/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:46 AM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
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
    private val getHighestPriceProductsUseCase: GetHighestPriceProductsUseCase,
    private val getCartTotalCountsUseCase: GetCartTotalCountsUseCase
): ViewModel() {

    private var _shopUiState = MutableStateFlow(MainShopProductsUiState(ShopProductsUiState.Loading))
    val shopUiState = _shopUiState.asStateFlow()

    private val _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    init {
        getProducts()
        getCartTotalCount()
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

    private fun getCartTotalCount() {
        viewModelScope.launch {
            getCartTotalCountsUseCase.invoke().collect {
                _cartTotalCountState.value = it!!
            }
        }
    }
}
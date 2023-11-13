/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/1/23, 11:47 PM
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

package com.example.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.product_reviews.GetProductReviewsUseCase
import com.example.domain.utils.ServiceResult
import com.example.productdetails.uistate.MainProductReviewsUiState
import com.example.productdetails.uistate.ProductReviewsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductReviewsViewModel @Inject constructor(
    private val getProductReviewsUseCase: GetProductReviewsUseCase
): ViewModel() {

    private var _reviewsState = MutableStateFlow(MainProductReviewsUiState(ProductReviewsUiState.Loading))
    val reviewsState = _reviewsState.asStateFlow()

    fun getProductReviews(productId: Int) {
        viewModelScope.launch {
            getProductReviewsUseCase.invoke(productId = productId).collect { reviewsResult ->
                val reviewsUiStateResult = when (reviewsResult) {
                    ServiceResult.Loading -> ProductReviewsUiState.Loading
                    is ServiceResult.Success -> ProductReviewsUiState.Success(
                        reviews = reviewsResult.data
                    )
                    is ServiceResult.Error -> ProductReviewsUiState.Error(
                        message = reviewsResult.throwable?.message!!
                    )
                }
                _reviewsState.value = MainProductReviewsUiState(
                    reviewsUiState = reviewsUiStateResult
                )
            }
        }
    }
}
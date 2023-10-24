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
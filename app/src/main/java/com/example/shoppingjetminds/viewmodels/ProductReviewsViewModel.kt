package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.product_reviews.GetProductReviewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductReviewsViewModel @Inject constructor(
    private val getProductReviewsUseCase: GetProductReviewsUseCase
): ViewModel() {
}
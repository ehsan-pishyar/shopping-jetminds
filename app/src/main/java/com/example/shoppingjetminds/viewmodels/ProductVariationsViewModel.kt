package com.example.shoppingjetminds.viewmodels

import com.example.domain.use_cases.product_variations.GetProductVariationDetailsUseCase
import com.example.domain.use_cases.product_variations.GetProductVariationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductVariationsViewModel @Inject constructor(
    private val getProductVariationsUseCase: GetProductVariationsUseCase,
    getProductVariationDetailsUseCase: GetProductVariationDetailsUseCase
) {
}
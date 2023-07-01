package com.example.domain.use_cases.product_variations

import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductVariationDetailsUseCase constructor(
    private val productVariationsRepository: ProductVariationsRepository
) {

    operator fun invoke(productId: Int, variationId: Int): Flow<ServiceResult<ProductVariationsResponse>> =
        productVariationsRepository.getProductVariationDetails(productId, variationId).asResult()
}
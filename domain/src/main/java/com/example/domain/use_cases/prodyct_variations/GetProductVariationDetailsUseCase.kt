package com.example.domain.use_cases.prodyct_variations

import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.domain.utils.ServiceResult

class GetProductVariationDetailsUseCase constructor(
    private val productVariationsRepository: ProductVariationsRepository
) {

    suspend operator fun invoke(productId: Int, variationId: Int): ServiceResult<ProductVariationsResponse> =
        productVariationsRepository.getProductVariationDetails(productId, variationId)
}
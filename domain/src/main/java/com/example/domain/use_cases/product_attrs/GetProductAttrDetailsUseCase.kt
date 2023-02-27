package com.example.domain.use_cases.product_attrs

import com.example.domain.models.ProductAttributesResponse
import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.utils.ServiceResult

class GetProductAttrDetailsUseCase constructor(
    private val productAttributesRepository: ProductAttributesRepository
) {

    suspend operator fun invoke(attrId: Int): ServiceResult<ProductAttributesResponse> =
        productAttributesRepository.getProductAttributeDetails(attrId)
}
package com.example.domain.use_cases.product_attrs

import com.example.domain.models.ProductAttributesResponse
import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductAttrDetailsUseCase constructor(
    private val productAttributesRepository: ProductAttributesRepository
) {

    operator fun invoke(attrId: Int): Flow<ServiceResult<ProductAttributesResponse>> =
        productAttributesRepository.getProductAttributeDetails(attrId).asResult()
}
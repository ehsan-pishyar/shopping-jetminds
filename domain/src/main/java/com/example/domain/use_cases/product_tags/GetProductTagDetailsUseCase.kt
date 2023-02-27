package com.example.domain.use_cases.product_tags

import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.utils.ServiceResult

class GetProductTagDetailsUseCase constructor(
    private val productTagsRepository: ProductTagsRepository
){

    suspend operator fun invoke(tagId: Int): ServiceResult<ProductTagsResponse> =
        productTagsRepository.getProductTagDetails(tagId)
}
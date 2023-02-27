package com.example.domain.use_cases.product_tags

import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetProductTagsUseCase constructor(
    private val productTagsRepository: ProductTagsRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<ProductTagsResponse>>> =
        productTagsRepository.getProductTags()
}
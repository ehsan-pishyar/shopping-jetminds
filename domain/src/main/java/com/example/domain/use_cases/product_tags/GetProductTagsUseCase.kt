package com.example.domain.use_cases.product_tags

import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductTagsUseCase constructor(
    private val productTagsRepository: ProductTagsRepository
) {

    operator fun invoke(): Flow<Result<List<ProductTagsResponse>>> =
        productTagsRepository.getProductTags().asResult()
}
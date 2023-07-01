package com.example.domain.use_cases.product_categories

import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow
import com.example.domain.utils.ServiceResult

class GetProductCategoryDetailsUseCase constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
) {

    operator fun invoke(categoryId: Int): Flow<ServiceResult<ProductCategoriesResponse>> =
        productCategoriesRepository.getProductCategoryDetails(categoryId).asResult()
}
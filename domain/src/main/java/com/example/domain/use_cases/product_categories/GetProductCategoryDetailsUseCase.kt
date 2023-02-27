package com.example.domain.use_cases.product_categories

import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.ServiceResult

class GetProductCategoryDetailsUseCase constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
) {

    suspend operator fun invoke(categoryId: Int): ServiceResult<ProductCategoriesResponse> =
        productCategoriesRepository.getProductCategoryDetails(categoryId)
}
package com.example.domain.use_cases.product_categories

import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetProductCategoriesUseCase constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
){

    operator fun invoke(): Flow<ServiceResult<List<ProductCategoriesResponse>>> =
        productCategoriesRepository.getProductCategories()
}
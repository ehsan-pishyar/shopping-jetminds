package com.example.domain.use_cases.product_categories

import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductCategoriesUseCase constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
){

    operator fun invoke(): Flow<Result<List<ProductCategoriesResponse>>> =
        productCategoriesRepository.getProductCategories().asResult()
}
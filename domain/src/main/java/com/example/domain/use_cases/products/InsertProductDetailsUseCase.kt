package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository

class InsertProductDetailsUseCase constructor(
    private val repository: ProductsRepository
) {

    suspend operator fun invoke(productDetails: ProductsResponse) {
        repository.insertProductDetails(productDetails = productDetails)
    }
}
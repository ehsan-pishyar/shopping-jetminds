package com.example.domain.use_cases.downloads

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.DownloadsRepository
import kotlinx.coroutines.flow.Flow

class GetDownloadedProductsUseCase(
    private val repository: DownloadsRepository
) {

    operator fun invoke(): Flow<List<ProductsResponse>> =
        repository.getDownloadedProducts()
}
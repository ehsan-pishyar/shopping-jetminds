package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface DownloadsRepository {

    fun getDownloadedProducts(): Flow<List<ProductsResponse>>
    suspend fun updateDownloadedProducts(
        productId: Int,
        downloaded: Boolean
    )
}
package com.example.repository.repository

import com.example.cache.dao.DownloadsDao
import com.example.cache.models.ProductsResponseEntity
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.DownloadsRepository
import com.example.repository.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DownloadsRepositoryImpl @Inject constructor(
    private val dao: DownloadsDao
): DownloadsRepository {

    override fun getDownloadedProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchDownloadedProducts().map { downloads ->
            downloads.map(ProductsResponseEntity::toDomain)
        }
    }

    override suspend fun updateDownloadedProducts(
        productId: Int,
        downloaded: Boolean
    ) {
        dao.updateDownloadedProduct(
            productId = productId,
            downloaded = downloaded
        )
    }
}
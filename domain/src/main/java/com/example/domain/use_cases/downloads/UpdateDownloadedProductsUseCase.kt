package com.example.domain.use_cases.downloads

import com.example.domain.repositories.DownloadsRepository

class UpdateDownloadedProductsUseCase(
    private val repository: DownloadsRepository
) {

    suspend operator fun invoke(
        productId: Int,
        downloaded: Boolean
    ) {
        repository.updateDownloadedProducts(
            productId = productId,
            downloaded = downloaded
        )
    }
}
package com.example.repository.data_source.remote

import com.example.network.ApiService
import javax.inject.Inject

class RemoteProductCategoriesDataSource @Inject constructor(
    private val api: ApiService
) {
}
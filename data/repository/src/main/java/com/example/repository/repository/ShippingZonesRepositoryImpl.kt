package com.example.repository.repository

import com.example.cache.dao.ShippingZonesDao
import com.example.domain.models.ShippingZonesResponse
import com.example.domain.repositories.ShippingZonesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import javax.inject.Inject

class ShippingZonesRepositoryImpl @Inject constructor(
    apiService: ApiService,
    shippingZonesDao: ShippingZonesDao
): ShippingZonesRepository {

    override suspend fun getShippingZones(): ServiceResult<List<ShippingZonesResponse>> {
        TODO("Not yet implemented")
    }
}
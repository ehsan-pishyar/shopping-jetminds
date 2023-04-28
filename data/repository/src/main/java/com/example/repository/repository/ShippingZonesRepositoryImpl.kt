package com.example.repository.repository

import com.example.cache.dao.ShippingZonesDao
import com.example.domain.models.ShippingZonesResponse
import com.example.domain.repositories.ShippingZonesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ShippingZonesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import java.io.IOException
import javax.inject.Inject

class ShippingZonesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val shippingZonesDao: ShippingZonesDao
): ShippingZonesRepository {

    override suspend fun getShippingZones(): ServiceResult<List<ShippingZonesResponse>> {
        TODO("Not yet implemented")
    }
}
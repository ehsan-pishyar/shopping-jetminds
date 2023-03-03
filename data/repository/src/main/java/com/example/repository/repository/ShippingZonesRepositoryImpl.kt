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
        val zonesEntity = shippingZonesDao.fetchShippingZones()

        if (shippingZonesDao.isShippingZonesCacheAvailable() > 0) {
            return ServiceResult.Success(data = zonesEntity.map { it.toDomain() })
        }

        val response = try {
            apiService.getShippingZones()
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } as ShippingZonesResponseDto

        response.let { zones ->
            shippingZonesDao.insertShippingZones(listOf(zones.toEntity()))
            return ServiceResult.Success(shippingZonesDao.fetchShippingZones().map { it.toDomain() })
        }
    }
}
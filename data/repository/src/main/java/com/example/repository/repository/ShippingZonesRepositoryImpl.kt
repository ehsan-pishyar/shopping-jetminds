package com.example.repository.repository

import com.example.cache.dao.ShippingZonesDao
import com.example.cache.models.ShippingZonesResponseEntity
import com.example.domain.models.ShippingZonesResponse
import com.example.domain.repositories.ShippingZonesRepository
import com.example.network.ApiService
import com.example.network.models.ShippingZonesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ShippingZonesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ShippingZonesDao
): ShippingZonesRepository {

    override fun getShippingZones(): Flow<List<ShippingZonesResponse>> {
        return dao.fetchShippingZones().map { zonesEntity ->
            zonesEntity.map(ShippingZonesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshShippingZones()
            }
        }
    }

    override suspend fun refreshShippingZones() {
        api.getShippingZones().also { zonesDto ->
            dao.deleteAndInsertShippingZones(
                shippingZones = zonesDto.map(
                    ShippingZonesResponseDto::toEntity
                )
            )
        }
    }
}
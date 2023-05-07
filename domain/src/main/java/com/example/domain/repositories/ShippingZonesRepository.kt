package com.example.domain.repositories

import com.example.domain.models.ShippingZonesResponse
import kotlinx.coroutines.flow.Flow

interface ShippingZonesRepository {

    fun getShippingZones(): Flow<List<ShippingZonesResponse>>
    suspend fun refreshShippingZones()
}
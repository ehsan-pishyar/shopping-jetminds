package com.example.domain.repositories

import com.example.domain.models.ShippingZonesResponse
import com.example.domain.utils.ServiceResult

interface ShippingZonesRepository {

    suspend fun getShippingZones(): ServiceResult<List<ShippingZonesResponse>>
}
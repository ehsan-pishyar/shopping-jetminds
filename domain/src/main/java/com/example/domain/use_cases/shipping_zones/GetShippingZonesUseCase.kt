package com.example.domain.use_cases.shipping_zones

import com.example.domain.models.ShippingZonesResponse
import com.example.domain.repositories.ShippingZonesRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetShippingZonesUseCase constructor(
    private val shippingZonesRepository: ShippingZonesRepository
) {

    suspend operator fun invoke(): ServiceResult<List<ShippingZonesResponse>> =
        shippingZonesRepository.getShippingZones()
}
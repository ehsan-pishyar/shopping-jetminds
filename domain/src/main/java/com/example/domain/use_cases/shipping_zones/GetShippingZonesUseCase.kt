package com.example.domain.use_cases.shipping_zones

import com.example.domain.models.ShippingZonesResponse
import com.example.domain.repositories.ShippingZonesRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetShippingZonesUseCase constructor(
    private val shippingZonesRepository: ShippingZonesRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<ShippingZonesResponse>>> =
        shippingZonesRepository.getShippingZones().asResult()
}
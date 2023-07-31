package com.example.shoppingjetminds.uistates

import com.example.domain.models.ShippingZonesResponse

sealed interface ShippingZonesUiState {
    object Loading: ShippingZonesUiState
    data class Success(val shippingZones: List<ShippingZonesResponse>): ShippingZonesUiState
    data class Error(val message: String): ShippingZonesUiState
}

data class MainShippingZonesUiState(
    val shippingZonesUiState: ShippingZonesUiState
)
package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ShippingZonesResponseDto(
    val id: Int,
    val name: String,
    val order: Int
)
package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShippingDto(
    @SerialName("address_1")
    val address1: String,
    @SerialName("address_2")
    val address2: String,
    val city: String,
    val company: String,
    val country: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    val postcode: String,
    val state: String
)
package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BillingDto(
    @SerialName("address_1")
    val address1: String,
    @SerialName("address_2")
    val address2: String,
    val city: String,
    val company: String,
    val country: String,
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    val phone: String,
    val postcode: String,
    val state: String
)
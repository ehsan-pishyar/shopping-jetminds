package com.example.network.models

import com.squareup.moshi.Json

data class ShippingDto(
    @Json(name = "address_1")
    val address1: String? = null,
    @Json(name = "address_2")
    val address2: String? = null,
    val city: String? = null,
    val company: String? = null,
    val country: String? = null,
    @Json(name = "first_name")
    val firstName: String? = null,
    @Json(name = "last_name")
    val lastName: String? = null,
    val postcode: String? = null,
    val state: String? = null
)
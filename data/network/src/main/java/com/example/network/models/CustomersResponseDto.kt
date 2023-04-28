package com.example.network.models

import com.squareup.moshi.Json


data class CustomersResponseDto(
    val id: Int? = null,
    @Json(name = "date_created")
    val dateCreated: String? = null,
    @Json(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    val email: String? = null,
    @Json(name = "first_name")
    val firstName: String? = null,
    @Json(name = "last_name")
    val lastName: String? = null,
    val role: String? = null,
    val username: String? = null,
    val billingDto: BillingDto? = null,
    val shippingDto: ShippingDto? = null,
    @Json(name = "is_paying_customer")
    val isPayingCustomer: Boolean? = null,
    @Json(name = "avatar_url")
    val avatarUrl: String? = null
)
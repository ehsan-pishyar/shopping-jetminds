package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomersResponseDto(
    val id: Int,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String,
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    val role: String,
    val username: String,
    val billingDto: BillingDto,
    val shippingDto: ShippingDto,
    @SerialName("is_paying_customer")
    val isPayingCustomer: Boolean,
    @SerialName("avatar_url")
    val avatarUrl: String
)
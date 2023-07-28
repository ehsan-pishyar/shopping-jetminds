package com.example.network.models

import com.google.gson.annotations.SerializedName

data class CustomersResponseDto(
    val id: Int,
    @SerializedName("date_created")
    val dateCreated: String,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val role: String,
    val username: String,
    @SerializedName("billing")
    val billingDto: BillingDto,
    @SerializedName("shipping")
    val shippingDto: ShippingDto,
    @SerializedName("is_paying_customer")
    val isPayingCustomer: Boolean,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
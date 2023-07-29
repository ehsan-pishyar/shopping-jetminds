package com.example.network.models

import com.google.gson.annotations.SerializedName

data class BillingDto(
    @SerializedName("address_1")
    val address1: String?,
    @SerializedName("address_2")
    val address2: String?,
    val city: String?,
    val company: String?,
    val country: String?,
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    val phone: String?,
    val postcode: String?,
    val state: String?
)
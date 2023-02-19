package com.example.network.models

data class CustomersResponse(
    val id: Int,
    val date_created: String,
    val date_created_gmt: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val role: String,
    val username: String,
    val billing: Billing,
    val shipping: Shipping,
    val is_paying_customer: Boolean,
    val avatar_url: String
)
package com.example.domain.models

data class CustomersResponse(
    val id: Int,
    val dateCreated: String,
    val dateCreatedGmt: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val role: String,
    val username: String,
    val billing: Billing,
    val shipping: Shipping,
    val isPayingCustomer: Boolean,
    val avatarUrl: String
)
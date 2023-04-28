package com.example.domain.models

data class CustomersResponse(
    val id: Int? = null,
    val dateCreated: String? = null,
    val dateCreatedGmt: String? = null,
    val email: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val role: String? = null,
    val username: String? = null,
    val billing: Billing? = null,
    val shipping: Shipping? = null,
    val isPayingCustomer: Boolean? = null,
    val avatarUrl: String? = null
)
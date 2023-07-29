package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class BillingEntity(
    val address1: String?,
    val address2: String?,
    val city: String?,
    val company: String?,
    val country: String?,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val phone: String?,
    val postcode: String?,
    val state: String?
)
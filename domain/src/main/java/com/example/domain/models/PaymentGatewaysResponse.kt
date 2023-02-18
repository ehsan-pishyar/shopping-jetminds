package com.example.domain.models

data class PaymentGatewaysResponse(
    val id: String,
    val title: String,
    val description: String,
    val order: Int,
    val enabled: Boolean,
    val method_title: String,
    val method_description: String,
    val settings: Settings
)
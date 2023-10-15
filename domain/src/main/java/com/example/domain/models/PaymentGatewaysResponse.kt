package com.example.domain.models

data class PaymentGatewaysResponse(
    val id: String,
    val title: String?,
    val description: String?,
    val order: String?,
    val enabled: Boolean?,
    val methodTitle: String?,
    val methodDescription: String?,
    val methodSupports: List<String>?,
    val settings: Settings?,
    val needsSetup: Boolean?,
    val settingsUrl: String?,
    val connectionUrl: String?,
    val setupHelpText: String?
)

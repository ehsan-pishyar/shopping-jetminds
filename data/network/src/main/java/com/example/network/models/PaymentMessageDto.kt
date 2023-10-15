package com.example.network.models

data class PaymentMessageDto(
    val id: String?,
    val label: String?,
    val description: String?,
    val type: String?,
    val value: String?,
    val default: String?,
    val tip: String?,
    val placeholder: String?
)
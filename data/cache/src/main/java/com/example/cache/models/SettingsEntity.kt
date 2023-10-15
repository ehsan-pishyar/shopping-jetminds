package com.example.cache.models

data class SettingsEntity(
    val baseConfig: PaymentMessageEntity?,
    val title: PaymentMessageEntity?,
    val accountConfig: PaymentMessageEntity?,
    val api: PaymentMessageEntity?,
    val merchantCode: PaymentMessageEntity?,
    val webServiceConfig: PaymentMessageEntity?,
    val apiKey: PaymentMessageEntity?,
    val successMassage: PaymentMessageEntity?,
    val failedMassage: PaymentMessageEntity?
)
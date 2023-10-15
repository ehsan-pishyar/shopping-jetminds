package com.example.domain.models

data class Settings(
    val baseConfig: PaymentMessage?,
    val title: PaymentMessage?,
    val accountConfig: PaymentMessage?,
    val api: PaymentMessage?,
    val merchantCode: PaymentMessage?,
    val webServiceConfig: PaymentMessage?,
    val apiKey: PaymentMessage?,
    val successMassage: PaymentMessage?,
    val failedMassage: PaymentMessage?
)

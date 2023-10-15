package com.example.network.models

import com.google.gson.annotations.SerializedName

data class SettingsDto(
    @SerializedName("base_confing")
    val baseConfig: PaymentMessageDto?,
    val title: PaymentMessageDto?,
    @SerializedName("account_confing")
    val accountConfig: PaymentMessageDto?,
    val api: PaymentMessageDto?,
    @SerializedName("merchantcode")
    val merchantCode: PaymentMessageDto?,
    @SerializedName("webservice_config")
    val webServiceConfig: PaymentMessageDto?,
    @SerializedName("api_key")
    val apiKey: PaymentMessageDto?,
    @SerializedName("success_massage")
    val successMassage: PaymentMessageDto?,
    @SerializedName("failed_massage")
    val failedMassage: PaymentMessageDto?
)
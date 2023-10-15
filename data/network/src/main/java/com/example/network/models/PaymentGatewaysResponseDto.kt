package com.example.network.models

import com.google.gson.annotations.SerializedName

data class PaymentGatewaysResponseDto(
    val id: String,
    val title: String?,
    val description: String?,
    val order: String?,
    val enabled: Boolean?,
    @SerializedName("method_title")
    val methodTitle: String?,
    @SerializedName("method_description")
    val methodDescription: String?,
    @SerializedName("method_supports")
    val methodSupports: List<String>?,
    @SerializedName("connection_url")
    val settings: SettingsDto?,
    @SerializedName("needs_setup")
    val needsSetup: Boolean?,
    @SerializedName("settings_url")
    val settingsUrl: String?,
    val connectionUrl: String?,
    @SerializedName("setup_help_text")
    val setupHelpText: String?
)
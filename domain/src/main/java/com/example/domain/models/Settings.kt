package com.example.domain.models

data class Settings(
    val address_override: AddressOverride,
    val identity_token: IdentityToken,
    val image_url: ImageUrl,
    val instructions: Instructions,
    val paymentaction: Paymentaction,
    val receiver_email: ReceiverEmail,
    val send_shipping: SendShipping,
    val title: Title
)
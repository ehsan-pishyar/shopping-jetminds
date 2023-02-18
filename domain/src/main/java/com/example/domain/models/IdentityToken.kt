package com.example.domain.models

data class IdentityToken(
    val id: String,
    val label: String,
    val description: String,
    val placeholder: String,
    val value: String,
    val type: String,
    val tip: String,
    val default: String
)
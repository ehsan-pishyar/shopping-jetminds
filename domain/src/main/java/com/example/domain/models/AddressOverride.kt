package com.example.domain.models

data class AddressOverride(
    val id: String,
    val label: String,
    val description: String,
    val placeholder: String,
    val type: String,
    val value: String,
    val default: String,
    val tip: String
)
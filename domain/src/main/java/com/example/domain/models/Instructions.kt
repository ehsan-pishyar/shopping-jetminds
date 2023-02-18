package com.example.domain.models

data class Instructions(
    val id: String,
    val label: String,
    val description: String,
    val placeholder: String,
    val value: String,
    val type: String,
    val default: String,
    val tip: String
)
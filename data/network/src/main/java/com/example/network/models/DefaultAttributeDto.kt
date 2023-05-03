package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class DefaultAttributeDto(
    val id: Int,
    val name: String,
    val option: String
)
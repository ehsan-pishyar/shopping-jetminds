package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class DefaultAttributeEntity(
    val id: Int?,
    val name: String?,
    val option: String?
)
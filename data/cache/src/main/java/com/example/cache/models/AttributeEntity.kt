package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class AttributeEntity(
    val id: Int,
    val name: String,
    val options: List<String>,
    val position: Int,
    val variation: Boolean,
    val visible: Boolean
)
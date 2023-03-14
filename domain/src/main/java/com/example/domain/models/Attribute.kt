package com.example.domain.models

data class Attribute(
    val id: Int? = null,
    val name: String? = null,
    val options: List<String>? = null,
    val position: Int? = null,
    val variation: Boolean? = null,
    val visible: Boolean? = null
)
package com.example.network.models

data class AttributeDto(
    val id: Int?,
    val name: String?,
    val options: List<String>?,
    val position: Int?,
    val variation: Boolean?,
    val visible: Boolean?
)
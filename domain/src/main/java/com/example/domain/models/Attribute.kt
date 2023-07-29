package com.example.domain.models

data class Attribute(
    val id: Int?,
    val name: String?,
    val options: List<String>?,
    val position: Int?,
    val variation: Boolean?,
    val visible: Boolean?
)
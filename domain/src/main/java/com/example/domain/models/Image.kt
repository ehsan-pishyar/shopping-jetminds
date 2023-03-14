package com.example.domain.models

data class Image(
    val id: Int? = null,
    val name: String? = null,
    val src: String? = null,
    val alt: String? = null,
    val dateCreated: String? = null,
    val dateCreatedGmt: String? = null
)
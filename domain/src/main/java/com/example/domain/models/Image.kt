package com.example.domain.models

data class Image(
    val id: Int,
    val name: String,
    val src: String,
    val alt: String,
    val dateCreated: String,
    val dateCreatedGmt: String
)
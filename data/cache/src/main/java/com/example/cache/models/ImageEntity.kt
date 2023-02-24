package com.example.cache.models

data class ImageEntity(
    val id: Int,
    val name: String,
    val src: String,
    val alt: String,
    val dateCreated: String,
    val dateCreatedGmt: String
)
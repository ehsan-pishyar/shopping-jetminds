package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    val id: Int,
    val name: String,
    val src: String,
    val alt: String,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String
)
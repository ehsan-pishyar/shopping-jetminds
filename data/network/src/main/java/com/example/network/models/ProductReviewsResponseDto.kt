package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductReviewsResponseDto(
    val id: Int,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String,
    @SerialName("product_id")
    val productId: Int,
    val status: String,
    val reviewer: String,
    @SerialName("reviewer_email")
    val reviewerEmail: String,
    val review: String,
    val rating: Int,
    val verified: Boolean,
)
package com.example.domain.models

data class ProductReviewsResponse(
    val id: Int,
    val dateCreated: String,
    val dateCreatedGmt: String,
    val productId: Int,
    val status: String,
    val reviewer: String,
    val reviewerEmail: String,
    val review: String,
    val rating: Int,
    val verified: Boolean
)
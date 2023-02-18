package com.example.domain.models

data class ProductReviewsResponse(
    val id: Int,
    val date_created: String,
    val date_created_gmt: String,
    val product_id: Int,
    val status: String,
    val reviewer: String,
    val reviewer_email: String,
    val review: String,
    val rating: Int,
    val verified: Boolean,
)
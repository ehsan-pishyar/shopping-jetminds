package com.example.domain.models

data class ProductReviewsResponse(
    val id: Int? = null,
    val dateCreated: String? = null,
    val dateCreatedGmt: String? = null,
    val productId: Int? = null,
    val status: String? = null,
    val reviewer: String? = null,
    val reviewerEmail: String? = null,
    val review: String? = null,
    val rating: Int? = null,
    val verified: Boolean? = null
)
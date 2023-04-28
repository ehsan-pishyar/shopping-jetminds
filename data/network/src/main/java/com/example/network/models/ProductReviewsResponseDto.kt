package com.example.network.models

import com.squareup.moshi.Json


data class ProductReviewsResponseDto(
    val id: Int? = null,
    @Json(name = "date_created")
    val dateCreated: String? = null,
    @Json(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    @Json(name = "product_id")
    val productId: Int? = null,
    val status: String? = null,
    val reviewer: String? = null,
    @Json(name = "reviewer_email")
    val reviewerEmail: String? = null,
    val review: String? = null,
    val rating: Int? = null,
    val verified: Boolean? = null,
)
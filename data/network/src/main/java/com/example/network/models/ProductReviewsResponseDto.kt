package com.example.network.models

import com.google.gson.annotations.SerializedName

data class ProductReviewsResponseDto(
    val id: Int?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String?,
    @SerializedName("product_id")
    val productId: Int?,
    val status: String?,
    val reviewer: String?,
    @SerializedName("reviewer_email")
    val reviewerEmail: String?,
    val review: String?,
    val rating: Int?,
    val verified: Boolean?,
    @SerializedName("reviewer_avatar_urls")
    val avatar: UserAvatarDto?
)
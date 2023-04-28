package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_REVIEWS_TABLE)
data class ProductReviewsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @ColumnInfo(name = "date_created")
    val dateCreated: String? = null,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    @ColumnInfo(name = "product_id")
    val productId: Int? = null,
    val status: String? = null,
    val reviewer: String? = null,
    @ColumnInfo(name = "reviewer_email")
    val reviewerEmail: String? = null,
    val review: String? = null,
    val rating: Int? = null,
    val verified: Boolean? = null,
)
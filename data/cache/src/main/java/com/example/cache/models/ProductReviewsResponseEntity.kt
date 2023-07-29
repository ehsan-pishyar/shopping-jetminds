package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_REVIEWS_TABLE)
data class ProductReviewsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String?,
    @ColumnInfo(name = "product_id")
    val productId: Int?,
    val status: String?,
    val reviewer: String?,
    @ColumnInfo(name = "reviewer_email")
    val reviewerEmail: String?,
    val review: String?,
    val rating: Int?,
    val verified: Boolean?,
)
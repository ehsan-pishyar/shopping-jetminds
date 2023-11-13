/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/30/23, 10:46 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    @ColumnInfo(name = "reviewer_avatar_urls")
    val avatar: UserAvatarEntity?
)
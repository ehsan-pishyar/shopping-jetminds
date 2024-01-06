/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/6/23, 12:11 AM
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

package com.example.cache.models.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.utils.CacheConstants

@Entity(
    tableName = CacheConstants.PRODUCT_CATEGORY_CROSS_REF_TABLE,
    primaryKeys = ["productId", "categoryId"],
    foreignKeys = [
        ForeignKey(
            entity = ProductsResponseEntity::class,
            parentColumns = ["id"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProductCategoriesResponseEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["product_id"]),
        Index(value = ["category_id"])
    ]
)
data class ProductAndCategoryCrossRefEntity(
    @ColumnInfo(name = "product_id")
    val productId: Int?,
    @ColumnInfo(name = "category_id")
    val categoryId: Int?
)
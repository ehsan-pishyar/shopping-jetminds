/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 11:20 PM
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

@Entity(tableName = CacheConstants.PRODUCT_ATTRS_TABLE)
data class ProductAttributesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val name: String?,
    val slug: String?,
    val type: String?,
    @ColumnInfo(name = "order_by")
    val orderBy: String?,
    @ColumnInfo(name = "has_archives")
    val hasArchives: Boolean?
)
/*
 * Copyright (c) 2024 JetMinds (Ehsan Pishyar)
 * Last Modified: 1/6/24, 9:51 PM
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

package com.example.cache.models.relations.helpers

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.models.relations.ProductAndCategoryCrossRefEntity

data class CategoryAndProducts(
    @Embedded
    val category: ProductCategoriesResponseEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "productId",
        associateBy = Junction(ProductAndCategoryCrossRefEntity::class)
    )
    val products: List<ProductsResponseEntity>
)

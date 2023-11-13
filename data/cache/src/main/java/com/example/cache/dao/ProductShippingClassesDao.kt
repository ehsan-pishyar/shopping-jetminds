/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 5/24/23, 11:53 PM
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

package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.ProductShippingClassesResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductShippingClassesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrIgnoreProductShippingClasses(productShippingClasses: List<ProductShippingClassesResponseEntity>)

    @Query("SELECT * FROM `product_shipping_classes_table`")
    fun fetchProductShippingClasses(): Flow<List<ProductShippingClassesResponseEntity>>

    @Query("DELETE FROM `product_shipping_classes_table`")
    suspend fun deleteProductShippingClasses()

    @Transaction
    suspend fun deleteAndInsertProductShippingClasses(productShippingClasses: List<ProductShippingClassesResponseEntity>) {
        deleteProductShippingClasses()
        insertOrIgnoreProductShippingClasses(productShippingClasses)
    }
}
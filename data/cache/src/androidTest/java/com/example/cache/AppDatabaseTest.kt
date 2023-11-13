/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/3/23, 6:14 PM
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

package com.example.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cache.dao.ProductCategoriesDao
import com.example.cache.models.ImageEntity
import com.example.cache.models.ProductCategoriesResponseEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var db: AppDatabase
    private lateinit var categoryDao: ProductCategoriesDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        categoryDao = db.productCategoriesDao()
    }

    @After
    @kotlin.jvm.Throws(IOException::class)
    fun tearDown() {
        db.close()
    }

    @Test
    fun productCategoriesDao() = runBlocking{
        val categories = listOf(
            ProductCategoriesResponseEntity(
                id = 10,
                name = "Application Ui Kit",
                slug = "application-ui-kit",
                parent = 1,
                description = "Application ui kit for mobile devices",
                display = "default",
                image = ImageEntity(
                    id = 1,
                    name = "image 1",
                    src = "https://jetminds.ir/wp-content/uploads/2023/06/android-banner.webp",
                    alt = "application ui kit"
                ),
                menuOrder = 0,
                count = 59
            ),
            ProductCategoriesResponseEntity(
                id = 11,
                name = "3D Icons",
                slug = "3d-icons",
                parent = 1,
                description = "3D icons for mobile devices",
                display = "default",
                image = ImageEntity(
                    id = 2,
                    name = "image 2",
                    src = "https://jetminds.ir/wp-content/uploads/2023/06/android-banner.webp",
                    alt = "3d icons"
                ),
                menuOrder = 0,
                count = 13
            ),
            ProductCategoriesResponseEntity(
                id = 12,
                name = "3D Illustrations",
                slug = "3d-illustrations",
                parent = 1,
                description = "3D illustrations for mobile devices",
                display = "default",
                image = ImageEntity(
                    id = 2,
                    name = "image 3",
                    src = "https://jetminds.ir/wp-content/uploads/2023/06/android-banner.webp",
                    alt = "3d illustrations"
                ),
                menuOrder = 0,
                count = 7
            ),
            ProductCategoriesResponseEntity(
                id = 13,
                name = "Android",
                slug = "android",
                parent = 1,
                description = "3D illustrations for mobile devices",
                display = "default",
                image = ImageEntity(
                    id = 2,
                    name = "image 3",
                    src = "https://jetminds.ir/wp-content/uploads/2023/06/android-banner.webp",
                    alt = "3d illustrations"
                ),
                menuOrder = 0,
                count = 7
            ),
        )

        categoryDao.deleteAndInsertCategories(categories)
        val getCategories = categoryDao.fetchProductCategories().first()
        assertEquals(categories, getCategories)
    }
}
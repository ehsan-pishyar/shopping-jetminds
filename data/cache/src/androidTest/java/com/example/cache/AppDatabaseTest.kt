package com.example.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cache.dao.ProductCategoriesDao
import com.example.cache.models.ImageEntity
import com.example.cache.models.ProductCategoriesResponseEntity
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
                id = 1,
                name = "Battery AA",
                image = ImageEntity(id = 1, src = "image 1")
            ),
            ProductCategoriesResponseEntity(
                id = 2,
                name = "Battery AAA",
                image = ImageEntity(id = 2, src = "image 2")
            ),
            ProductCategoriesResponseEntity(
                id = 3,
                name = "Battery C",
                image = ImageEntity(id = 3, src = "image 3")
            )
        )

        categoryDao.deleteAndInsertCategories(categories)
        val getCategories = categoryDao.fetchProductCategories()
    }
}
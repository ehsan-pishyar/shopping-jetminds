package com.example.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cache.converters.*
import com.example.cache.dao.*
import com.example.cache.models.*
import com.example.cache.utils.CacheConstants

@Database(
    entities = [
        CouponsResponseEntity::class,
        CustomersResponseEntity::class,
        OrdersResponseEntity::class,
        ProductAttributesResponseEntity::class,
        ProductCategoriesResponseEntity::class,
        ProductReviewsResponseEntity::class,
        ProductShippingClassesResponseEntity::class,
        ProductsResponseEntity::class,
        ProductsTagsResponseEntity::class,
        ProductVariationsResponseEntity::class,
        ShippingZonesResponseEntity::class
    ],
    version = CacheConstants.DB_VERSION,
    exportSchema = false
)

@TypeConverters(
    CouponsConverter::class,
    CustomersConverter::class,
    OrdersConverter::class,
    ProductAttributesConverter::class,
    ProductCategoriesConverter::class,
    ProductReviewsConverter::class,
    ProductsConverter::class,
    ProductShippingClassesConverter::class,
    ProductTagsConverter::class,
    ProductVariationsConverter::class,
    ShippingZonesConverter::class
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun couponsDao(): CouponsDao
    abstract fun customersDao(): CustomersDao
    abstract fun ordersDao(): OrdersDao
    abstract fun productAttributesDao(): ProductAttributesDao
    abstract fun productCategoriesDao(): ProductCategoriesDao
    abstract fun productReviewsDao(): ProductReviewsDao
    abstract fun productsDao(): ProductsDao
    abstract fun productShippingClassesDao(): ProductShippingClassesDao
    abstract fun productTagsDao(): ProductTagsDao
    abstract fun productVariationsDao(): ProductVariationsDao
    abstract fun shippingZonesDao(): ShippingZonesDao
}
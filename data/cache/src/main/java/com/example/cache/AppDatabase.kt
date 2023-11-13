/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:13 AM
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

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cache.converters.*
import com.example.cache.dao.*
import com.example.cache.models.*
import com.example.cache.models.relations.ProductAndAttrCrossRefEntity
import com.example.cache.models.relations.ProductAndCategoryCrossRefEntity
import com.example.cache.models.relations.ProductAndTagCrossRefEntity
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
        ProductTagsResponseEntity::class,
        ProductVariationsResponseEntity::class,
        ShippingZonesResponseEntity::class,
        CategoryEntity::class,
        TagEntity::class,
        AttributeEntity::class,
        ImageEntity::class,
        CartEntity::class,
        PaymentGatewaysResponseEntity::class,
        ProductAndCategoryCrossRefEntity::class,
        ProductAndTagCrossRefEntity::class,
        ProductAndAttrCrossRefEntity::class
    ],
    version = CacheConstants.DB_VERSION,
    exportSchema = false
)

@TypeConverters(
    AttributesConverter::class,
    BillingsConverter::class,
    CategoriesConverter::class,
    CouponsConverter::class,
    CustomersConverter::class,
    DefaultAttributesConverter::class,
    ImageConverter::class,
    ImagesConverter::class,
    IntegerListConverter::class,
    LineItemsConverter::class,
    OrdersConverter::class,
    ProductAttributesConverter::class,
    ProductCategoriesConverter::class,
    ProductReviewsConverter::class,
    ProductConverter::class,
    ProductsConverter::class,
    ProductShippingClassesConverter::class,
    ProductTagsConverter::class,
    ProductVariationsConverter::class,
    ShippingLinesConverter::class,
    ShippingsConverter::class,
    ShippingZonesConverter::class,
    StringListConverter::class,
    TagsConverter::class,
    TaxesConverter::class,
    TaxLinesConverter::class,
    UserAvatarConverter::class,
    CartConverter::class,
    PaymentGatewaysConverter::class,
    SettingsConverter::class,
    PaymentMessageConverter::class
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
    abstract fun favoritesDao(): FavoritesDao
    abstract fun downloadsDao(): DownloadsDao
    abstract fun cartDao(): CartDao
    abstract fun paymentGatewaysDao(): PaymentGatewaysDao
}
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

package com.example.cache.di

import com.example.cache.AppDatabase
import com.example.cache.dao.CartDao
import com.example.cache.dao.CouponsDao
import com.example.cache.dao.CustomersDao
import com.example.cache.dao.DownloadsDao
import com.example.cache.dao.FavoritesDao
import com.example.cache.dao.OrdersDao
import com.example.cache.dao.PaymentGatewaysDao
import com.example.cache.dao.ProductAttributesDao
import com.example.cache.dao.ProductCategoriesDao
import com.example.cache.dao.ProductReviewsDao
import com.example.cache.dao.ProductShippingClassesDao
import com.example.cache.dao.ProductTagsDao
import com.example.cache.dao.ProductVariationsDao
import com.example.cache.dao.ProductsDao
import com.example.cache.dao.ShippingZonesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @[Provides Singleton]
    fun providesCouponsDao(database: AppDatabase): CouponsDao = database.couponsDao()

    @[Provides Singleton]
    fun providesCustomersDao(database: AppDatabase): CustomersDao = database.customersDao()

    @[Provides Singleton]
    fun providesOrdersDao(database: AppDatabase): OrdersDao = database.ordersDao()

    @[Provides Singleton]
    fun providesProductAttributesDao(database: AppDatabase): ProductAttributesDao = database.productAttributesDao()

    @[Provides Singleton]
    fun providesProductCategoriesDao(database: AppDatabase): ProductCategoriesDao = database.productCategoriesDao()

    @[Provides Singleton]
    fun providesProductReviewsDao(database: AppDatabase): ProductReviewsDao = database.productReviewsDao()

    @[Provides Singleton]
    fun providesProductsDao(database: AppDatabase): ProductsDao = database.productsDao()

    @[Provides Singleton]
    fun providesProductShippingClassesDao(database: AppDatabase): ProductShippingClassesDao = database.productShippingClassesDao()

    @[Provides Singleton]
    fun providesProductTagsDao(database: AppDatabase): ProductTagsDao = database.productTagsDao()

    @[Provides Singleton]
    fun providesProductVariationsDao(database: AppDatabase): ProductVariationsDao = database.productVariationsDao()

    @[Provides Singleton]
    fun providesShippingZonesDao(database: AppDatabase): ShippingZonesDao = database.shippingZonesDao()

    @[Provides Singleton]
    fun providesFavoritesDao(db: AppDatabase): FavoritesDao = db.favoritesDao()

    @[Provides Singleton]
    fun providesDownloadsDao(db: AppDatabase): DownloadsDao = db.downloadsDao()

    @[Provides Singleton]
    fun providesCartDao(db: AppDatabase): CartDao = db.cartDao()

    @[Provides Singleton]
    fun providesPaymentGatewaysDao(db: AppDatabase): PaymentGatewaysDao = db.paymentGatewaysDao()
}
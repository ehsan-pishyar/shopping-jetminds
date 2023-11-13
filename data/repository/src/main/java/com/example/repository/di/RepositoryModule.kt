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

package com.example.repository.di

import com.example.cache.dao.*
import com.example.domain.repositories.*
import com.example.domain.use_cases.products.*
import com.example.repository.repository.*
import com.example.repository.repository.wordpress.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun providesProductCategoriesRepository(
        impl: ProductCategoriesRepositoryImpl
    ): ProductCategoriesRepository

    @[Binds Singleton]
    fun providesProductsRepository(
        impl: ProductsRepositoryImpl
    ): ProductsRepository

    @[Binds Singleton]
    fun providesCouponsRepository(
        impl: CouponsRepositoryImpl
    ): CouponsRepository

    @[Binds Singleton]
    fun providesOrdersRepository(
        impl: OrdersRepositoryImpl
    ): OrdersRepository

    @[Binds Singleton]
    fun providesProductAttrsRepository(
        impl: ProductAttributesRepositoryImpl
    ): ProductAttributesRepository

    @[Binds Singleton]
    fun providesProductReviewsRepository(
        impl: ProductReviewsRepositoryImpl
    ): ProductReviewsRepository

    @[Binds Singleton]
    fun providesProductShippingClassesRepository(
        impl: ProductShippingClassesRepositoryImpl
    ): ProductShippingClassesRepository

    @[Binds Singleton]
    fun providesProductTagsRepository(
        impl: ProductTagsRepositoryImpl
    ): ProductTagsRepository

    @[Binds Singleton]
    fun providesProductVariationRepository(
        impl: ProductVariationsRepositoryImpl
    ): ProductVariationsRepository

    @[Binds Singleton]
    fun providesShippingZonesRepository(
        impl: ShippingZonesRepositoryImpl
    ): ShippingZonesRepository

    @[Binds Singleton]
    fun bindsFavoritesRepository(
        impl: FavoritesRepositoryImpl
    ): FavoritesRepository

    @[Binds Singleton]
    fun bindsDownloadsRepository(
        impl: DownloadsRepositoryImpl
    ): DownloadsRepository

    @[Binds Singleton]
    fun bindsCustomerRepository(
        impl: CustomerRepositoryImpl
    ): CustomerRepository

    @[Binds Singleton]
    fun bindsCartItemRepository(
        impl: CartRepositoryImpl
    ): CartRepository

    @[Binds Singleton]
    fun bindsPaymentGatewayRepository(
        impl: PaymentGatewaysRepositoryImpl
    ): PaymentGatewaysRepository

    @[Binds Singleton]
    fun bindsUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}
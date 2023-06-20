package com.example.repository.di

import com.example.cache.dao.*
import com.example.domain.repositories.*
import com.example.domain.use_cases.products.*
import com.example.repository.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providesProductCategoriesRepository(
        impl: ProductCategoriesRepositoryImpl
    ): ProductCategoriesRepository

    @Binds
    fun providesProductsRepository(
        impl: ProductsRepositoryImpl
    ): ProductsRepository

    @Binds
    fun providesCouponsRepository(
        impl: CouponsRepositoryImpl
    ): CouponsRepository

    @Binds
    fun providesOrdersRepository(
        impl: OrdersRepositoryImpl
    ): OrdersRepository

    @Binds
    fun providesProductAttrsRepository(
        impl: ProductAttributesRepositoryImpl
    ): ProductAttributesRepository

    @Binds
    fun providesProductReviewsRepository(
        impl: ProductReviewsRepositoryImpl
    ): ProductReviewsRepository

    @Binds
    fun providesProductShippingClassesRepository(
        impl: ProductShippingClassesRepositoryImpl
    ): ProductShippingClassesRepository

    @Binds
    fun providesProductTagsRepository(
        impl: ProductTagsRepositoryImpl
    ): ProductTagsRepository

    @Binds
    fun providesProductVariationRepository(
        impl: ProductVariationsRepositoryImpl
    ): ProductVariationsRepository

    @Binds
    fun providesShippingZonesRepository(
        impl: ShippingZonesRepositoryImpl
    ): ShippingZonesRepository
}
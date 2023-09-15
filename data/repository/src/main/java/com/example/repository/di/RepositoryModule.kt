package com.example.repository.di

import com.example.cache.dao.*
import com.example.domain.repositories.*
import com.example.domain.use_cases.products.*
import com.example.repository.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun providesProductCategoriesRepository(
        impl: ProductCategoriesRepositoryImpl
    ): ProductCategoriesRepository

    @Binds
    @Singleton
    fun providesProductsRepository(
        impl: ProductsRepositoryImpl
    ): ProductsRepository

    @Binds
    @Singleton
    fun providesCouponsRepository(
        impl: CouponsRepositoryImpl
    ): CouponsRepository

    @Binds
    @Singleton
    fun providesOrdersRepository(
        impl: OrdersRepositoryImpl
    ): OrdersRepository

    @Binds
    @Singleton
    fun providesProductAttrsRepository(
        impl: ProductAttributesRepositoryImpl
    ): ProductAttributesRepository

    @Binds
    @Singleton
    fun providesProductReviewsRepository(
        impl: ProductReviewsRepositoryImpl
    ): ProductReviewsRepository

    @Binds
    @Singleton
    fun providesProductShippingClassesRepository(
        impl: ProductShippingClassesRepositoryImpl
    ): ProductShippingClassesRepository

    @Binds
    @Singleton
    fun providesProductTagsRepository(
        impl: ProductTagsRepositoryImpl
    ): ProductTagsRepository

    @Binds
    @Singleton
    fun providesProductVariationRepository(
        impl: ProductVariationsRepositoryImpl
    ): ProductVariationsRepository

    @Binds
    @Singleton
    fun providesShippingZonesRepository(
        impl: ShippingZonesRepositoryImpl
    ): ShippingZonesRepository

    @[Binds Singleton]
    fun bindsCartRepository(
        impl: CartRepositoryImpl
    ): CartRepository

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
}
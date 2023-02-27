package com.example.repository.di

import com.example.cache.dao.*
import com.example.domain.repositories.*
import com.example.network.ApiService
import com.example.repository.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    // Coupons
    @Provides
    fun providesCouponsRepositoryImpl(
        apiService: ApiService,
        couponsDao: CouponsDao
    ): CouponsRepositoryImpl = CouponsRepositoryImpl(apiService, couponsDao)

    @Provides
    fun providesCouponsRepository(
        couponsRepositoryImpl: CouponsRepositoryImpl
    ): CouponsRepository = couponsRepositoryImpl

    // Orders
    @Provides
    fun providesOrdersRepositoryImpl(
        apiService: ApiService,
        ordersDao: OrdersDao
    ): OrdersRepositoryImpl = OrdersRepositoryImpl(apiService, ordersDao)

    @Provides
    fun providesOrdersRepository(
        orderRepositoryImpl: OrdersRepositoryImpl
    ): OrdersRepository = orderRepositoryImpl

    // Product Attributes
    @Provides
    fun providesProductAttributesRepositoryImpl(
        apiService: ApiService,
        productAttributesDao: ProductAttributesDao
    ): ProductAttributesRepositoryImpl = ProductAttributesRepositoryImpl(apiService, productAttributesDao)

    @Provides
    fun providesProductAttributeRepository(
        productAttributesRepositoryImpl: ProductAttributesRepositoryImpl
    ): ProductAttributesRepository = productAttributesRepositoryImpl

    // Product Categories
    @Provides
    fun productCategoriesRepositoryImpl(
        apiService: ApiService,
        productCategoriesDao: ProductCategoriesDao
    ): ProductCategoriesRepositoryImpl = ProductCategoriesRepositoryImpl(apiService, productCategoriesDao)

    @Provides
    fun productCategoriesRepository(
        productCategoriesRepositoryImpl: ProductCategoriesRepositoryImpl
    ): ProductCategoriesRepository = productCategoriesRepositoryImpl

    // Product Reviews
    @Provides
    fun providesProductReviewsRepositoryImpl(
        apiService: ApiService,
        productReviewsDao: ProductReviewsDao
    ): ProductReviewsRepositoryImpl = ProductReviewsRepositoryImpl(apiService, productReviewsDao)

    @Provides
    fun providesProductReviewsRepository(
        productReviewsRepositoryImpl: ProductReviewsRepositoryImpl
    ): ProductReviewsRepository = productReviewsRepositoryImpl

    // Product Shipping Classes
    @Provides
    fun providesProductShippingClassesRepositoryImpl(
        apiService: ApiService,
        productShippingClassesDao: ProductShippingClassesDao
    ): ProductShippingClassesRepositoryImpl = ProductShippingClassesRepositoryImpl(apiService, productShippingClassesDao)

    @Provides
    fun providesProductShippingClassesRepository(
        productShippingClassesRepositoryImpl: ProductShippingClassesRepositoryImpl
    ): ProductShippingClassesRepository = productShippingClassesRepositoryImpl

    // Products
    @Provides
    fun providesProductsRepositoryImpl(
        apiService: ApiService,
        productsDao: ProductsDao
    ): ProductsRepositoryImpl = ProductsRepositoryImpl(apiService, productsDao)

    @Provides
    fun providesProductsRepository(
        productsRepositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository = productsRepositoryImpl

    // Product Tags
    @Provides
    fun providesProductTagsRepositoryImpl(
        apiService: ApiService,
        productTagsDao: ProductTagsDao
    ): ProductTagsRepositoryImpl = ProductTagsRepositoryImpl(apiService, productTagsDao)

    @Provides
    fun providesProductTagsRepository(
        productTagsRepositoryImpl: ProductTagsRepositoryImpl
    ): ProductTagsRepository = productTagsRepositoryImpl

    // Product Variations
    @Provides
    fun providesProductVariationsRepositoryImpl(
        apiService: ApiService,
        productVariationsDao: ProductVariationsDao
    ): ProductVariationsRepositoryImpl = ProductVariationsRepositoryImpl(apiService, productVariationsDao)

    @Provides
    fun providesProductVariationsRepository(
        productVariationsRepositoryImpl: ProductVariationsRepositoryImpl
    ): ProductVariationsRepository = productVariationsRepositoryImpl

    // Shipping Zones
    @Provides
    fun providesShippingZonesRepositoryImpl(
        apiService: ApiService,
        shippingZonesDao: ShippingZonesDao
    ): ShippingZonesRepositoryImpl = ShippingZonesRepositoryImpl(apiService, shippingZonesDao)

    @Provides
    fun providesShippingZonesRepository(
        shippingZonesRepositoryImpl: ShippingZonesRepositoryImpl
    ): ShippingZonesRepository = shippingZonesRepositoryImpl
}
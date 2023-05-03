package com.example.cache.di

import com.example.cache.AppDatabase
import com.example.cache.dao.CouponsDao
import com.example.cache.dao.CustomersDao
import com.example.cache.dao.OrdersDao
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

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesCouponsDao(database: AppDatabase): CouponsDao = database.couponsDao()

    @Provides
    fun providesCustomersDao(database: AppDatabase): CustomersDao = database.customersDao()

    @Provides
    fun providesOrdersDao(database: AppDatabase): OrdersDao = database.ordersDao()

    @Provides
    fun providesProductAttributesDao(database: AppDatabase): ProductAttributesDao = database.productAttributesDao()

    @Provides
    fun providesProductCategoriesDao(database: AppDatabase): ProductCategoriesDao = database.productCategoriesDao()

    @Provides
    fun providesProductReviewsDao(database: AppDatabase): ProductReviewsDao = database.productReviewsDao()

    @Provides
    fun providesProductsDao(database: AppDatabase): ProductsDao = database.productsDao()

    @Provides
    fun providesProductShippingClassesDao(database: AppDatabase): ProductShippingClassesDao = database.productShippingClassesDao()

    @Provides
    fun providesProductTagsDao(database: AppDatabase): ProductTagsDao = database.productTagsDao()

    @Provides
    fun providesProductVariationsDao(database: AppDatabase): ProductVariationsDao = database.productVariationsDao()

    @Provides
    fun providesShippingZonesDao(database: AppDatabase): ShippingZonesDao = database.shippingZonesDao()
}
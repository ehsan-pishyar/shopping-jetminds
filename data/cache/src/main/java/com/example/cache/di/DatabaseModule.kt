package com.example.cache.di

import android.content.Context
import androidx.room.Room
import com.example.cache.AppDatabase
import com.example.cache.dao.*
import com.example.cache.utils.CacheConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            CacheConstants.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

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
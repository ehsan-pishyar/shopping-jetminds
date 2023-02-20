package com.example.cache.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
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

    @Singleton
    @Provides
    fun providesCouponsDao(database: AppDatabase): CouponsDao = database.couponsDao()

    @Singleton
    @Provides
    fun providesCustomersDao(database: AppDatabase): CustomersDao = database.customersDao()

    @Singleton
    @Provides
    fun providesOrdersDao(database: AppDatabase): OrdersDao = database.ordersDao()

    @Singleton
    @Provides
    fun providesProductAttributesDao(database: AppDatabase): ProductAttributesDao = database.productAttributesDao()

    @Singleton
    @Provides
    fun providesProductCategoriesDao(database: AppDatabase): ProductCategoriesDao = database.productCategoriesDao()

    @Singleton
    @Provides
    fun providesProductReviewsDao(database: AppDatabase): ProductReviewsDao = database.productReviewsDao()

    @Singleton
    @Provides
    fun providesProductsDao(database: AppDatabase): ProductsDao = database.productsDao()

    @Singleton
    @Provides
    fun providesProductShippingClassesDao(database: AppDatabase): ProductShippingClassesDao = database.productShippingClassesDao()

    @Singleton
    @Provides
    fun providesProductTagsDao(database: AppDatabase): ProductTagsDao = database.productTagsDao()

    @Singleton
    @Provides
    fun providesProductVariationsDao(database: AppDatabase): ProductVariationsDao = database.productVariationsDao()

    @Singleton
    @Provides
    fun providesShippingZonesDao(database: AppDatabase): ShippingZonesDao = database.shippingZonesDao()

}
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
    UserAvatarConverter::class
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
    abstract fun cartDao(): CartDao
    abstract fun favoritesDao(): FavoritesDao
    abstract fun downloadsDao(): DownloadsDao
}
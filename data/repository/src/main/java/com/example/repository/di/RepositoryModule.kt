package com.example.repository.di

import com.example.cache.dao.*
import com.example.domain.repositories.*
import com.example.domain.use_cases.coupons.GetCouponDetailsUseCase
import com.example.domain.use_cases.coupons.GetCouponsUseCase
import com.example.domain.use_cases.orders.GetOrderDetailsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoriesUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoryDetailsUseCase
import com.example.domain.use_cases.product_reviews.GetProductReviewsUseCase
import com.example.domain.use_cases.product_shipping_classes.GetProductShippingClassesUseCase
import com.example.domain.use_cases.product_tags.GetProductTagDetailsUseCase
import com.example.domain.use_cases.product_tags.GetProductTagsUseCase
import com.example.domain.use_cases.product_variations.GetProductVariationDetailsUseCase
import com.example.domain.use_cases.product_variations.GetProductVariationsUseCase
import com.example.domain.use_cases.products.*
import com.example.domain.use_cases.shipping_zones.GetShippingZonesUseCase
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

    @Provides
    fun providesGetCouponsUseCase(couponsRepository: CouponsRepository): GetCouponsUseCase =
        GetCouponsUseCase(couponsRepository)

    @Provides
    fun providesGetCouponDetailsUseCase(couponsRepository: CouponsRepository): GetCouponDetailsUseCase =
        GetCouponDetailsUseCase(couponsRepository)


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

    @Provides
    fun providesGetOrdersUseCase(ordersRepository: OrdersRepository): GetOrdersUseCase =
        GetOrdersUseCase(ordersRepository)

    @Provides
    fun providesGetOrderDetailsUseCase(ordersRepository: OrdersRepository): GetOrderDetailsUseCase =
        GetOrderDetailsUseCase(ordersRepository)


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

    @Provides
    fun providesGetProductAttributesUseCase(
        productAttributesRepository: ProductAttributesRepository
    ): GetProductAttrsUseCase = GetProductAttrsUseCase(productAttributesRepository)

    @Provides
    fun providesGetProductAttributeDetailsUseCase(
        productAttributesRepository: ProductAttributesRepository
    ): GetProductAttrDetailsUseCase = GetProductAttrDetailsUseCase(productAttributesRepository)


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

    @Provides
    fun providesGetProductCategoriesUseCase(
        productCategoriesRepository: ProductCategoriesRepository
    ): GetProductCategoriesUseCase = GetProductCategoriesUseCase(productCategoriesRepository)

    @Provides
    fun providesGetProductCategoryDetailsUseCase(
        productCategoriesRepository: ProductCategoriesRepository
    ): GetProductCategoryDetailsUseCase = GetProductCategoryDetailsUseCase(productCategoriesRepository)


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

    @Provides
    fun providesGetProductReviewsUseCase(
        productsReviewsRepository: ProductReviewsRepository
    ): GetProductReviewsUseCase = GetProductReviewsUseCase(productsReviewsRepository)


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

    @Provides
    fun providesGetProductShippingClassesUseCase(
        productShippingClassesRepository: ProductShippingClassesRepository
    ): GetProductShippingClassesUseCase = GetProductShippingClassesUseCase(productShippingClassesRepository)


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

    @Provides
    fun providesGetProductsUseCase(
        productsRepository: ProductsRepository
    ): GetProductsUseCase = GetProductsUseCase(productsRepository)

    @Provides
    fun providesGetProductDetailsUseCase(
        productsRepository: ProductsRepository
    ): GetProductDetailsUseCase = GetProductDetailsUseCase(productsRepository)

    @Provides
    fun providesGetProductsByCategoryIdUseCase(
        productsRepository: ProductsRepository
    ): GetProductsByCategoryIdUseCase = GetProductsByCategoryIdUseCase(productsRepository)

    @Provides
    fun providesGetProductsByTagIdUseCase(
        productsRepository: ProductsRepository
    ): GetProductsByTagIdUseCase = GetProductsByTagIdUseCase(productsRepository)

    @Provides
    fun providesGetProductsByAttrIdIdUseCase(
        productsRepository: ProductsRepository
    ): GetProductsByAttrIdUseCase = GetProductsByAttrIdUseCase(productsRepository)


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

    @Provides
    fun providesGetProductTagsUseCase(
        productTagsRepository: ProductTagsRepository
    ): GetProductTagsUseCase = GetProductTagsUseCase(productTagsRepository)

    @Provides
    fun providesGetProductTagDetailsUseCase(
        productTagsRepository: ProductTagsRepository
    ): GetProductTagDetailsUseCase = GetProductTagDetailsUseCase(productTagsRepository)


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

    @Provides
    fun providesGetProductVariationsUseCase(
        productVariationsRepository: ProductVariationsRepository
    ): GetProductVariationsUseCase = GetProductVariationsUseCase(productVariationsRepository)

    @Provides
    fun providesGetProductVariationDetailsUseCase(
        productVariationsRepository: ProductVariationsRepository
    ): GetProductVariationDetailsUseCase = GetProductVariationDetailsUseCase(productVariationsRepository)


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

    @Provides
    fun providesGetShippingZonesUseCase(
        shippingZonesRepository: ShippingZonesRepository
    ): GetShippingZonesUseCase = GetShippingZonesUseCase(shippingZonesRepository)
}
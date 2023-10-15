package com.example.network

import com.example.network.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Products -----------------------------------------------------------------------
    @GET("products")
    suspend fun getProducts(
        @Query("per_page") perPage: Int = 100
    ): List<ProductsResponseDto>

    @GET("products/{id}")
    suspend fun getProductDetails(
        @Path("id") productId: Int
    ): ProductsResponseDto

    @GET("products/{product_id}/variations/")
    suspend fun getProductVariations(
        @Path("product_id") productId: Int
    ): List<ProductVariationsResponseDto>

    @GET("products/{product_id}/variations/{id}")
    suspend fun getProductVariationDetails(
        @Path("product_id") productId: Int,
        @Path("id") variationId: Int
    ): ProductVariationsResponseDto

    @GET("products/attributes")
    suspend fun getProductAttributes(): List<ProductAttributesResponseDto>

    @GET("products/attributes/{id}")
    suspend fun getProductAttributeDetails(
        @Path("id") attrId: Int
    ): ProductAttributesResponseDto

    @GET("products/categories")
    suspend fun getProductCategories(
        @Query("per_page") perPage: Int = 100
    ): List<ProductCategoriesResponseDto>

    @GET("products/categories/{id}")
    suspend fun getProductCategoryDetails(
        @Path("id") categoryId: Int
    ): ProductCategoriesResponseDto

    @GET("products/shipping_classes/")
    suspend fun getProductShippingClasses(): List<ProductShippingClassesResponseDto>

    @GET("products/tags")
    suspend fun getProductTags(
        @Query("per_page") perPage: Int = 100
    ): List<ProductTagsResponseDto>

    @GET("products/tags/{id}")
    suspend fun getProductTagDetails(
        @Path("id") tagId: Int
    ): ProductTagsResponseDto

    @GET("products/reviews")
    suspend fun getProductReviews(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20,
    ): List<ProductReviewsResponseDto>

    @GET("products/reviews/{id}")
    suspend fun getProductReviewDetails(
        @Path("id") reviewId: Int
    ): ProductReviewsResponseDto

    @GET("products/payment_gateways")
    suspend fun getProductPaymentGateways(): List<PaymentGatewaysResponseDto>

    // Orders -------------------------------------------------------------------------
    @GET("orders")
    suspend fun getOrders(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20,
    ): List<OrdersResponseDto>

    @GET("orders/{id}")
    suspend fun getOrderDetails(
        @Path("id") orderId: Int
    ): OrdersResponseDto

    // Shipping Zones -----------------------------------------------------------------
    @GET("shipping/zones")
    suspend fun getShippingZones(): List<ShippingZonesResponseDto>

    // Customers ---------------------------------------------------------------------
    @GET("customers/{id}")
    suspend fun getCustomer(
        @Path("id") customerId: Int
    ): CustomersResponseDto

    // Coupons ----------------------------------------------------------------------
    @GET("coupons")
    suspend fun getCoupons(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20,
    ): List<CouponsResponseDto>

    @GET("coupons/{id}")
    suspend fun getCouponDetails(
        @Path("id") couponId: Int
    ): CouponsResponseDto
}
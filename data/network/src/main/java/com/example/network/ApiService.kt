package com.example.network

import com.example.network.models.*
import com.example.network.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Products -----------------------------------------------------------------------
    @GET("/products")
    suspend fun getProducts(
        @Query("page") page: Int = 1,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductsResponseDto

    @GET("/products/{id}")
    suspend fun getProductDetails(
        @Path("id") productId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductsResponseDto

    @GET("/products/{product_id}/variations/")
    suspend fun getProductVariations(
        @Path("product_id") productId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductVariationsResponseDto

    @GET("/products/{product_id}/variations/{id}")
    suspend fun getProductVariationDetails(
        @Path("product_id") productId: Int,
        @Path("id") variationId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductVariationsResponseDto

    @GET("/products/attributes")
    suspend fun getProductAttributes(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductAttributesResponseDto

    @GET("/products/attributes/{id}")
    suspend fun getProductAttributeDetails(
        @Path("id") attrId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductAttributesResponseDto

    @GET("/products/categories")
    suspend fun getProductsCategories(
        @Query("page") page: Int = 1,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductCategoriesResponseDto

    @GET("/products/categories/{id}")
    suspend fun getProductCategoryDetails(
        @Path("id") categoryId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductCategoriesResponseDto

    @GET("/products/shipping_classes/")
    suspend fun getProductShippingClasses(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductShippingClassesResponseDto

    @GET("/products/tags")
    suspend fun getProductsTags(
        @Query("page") page: Int = 1,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductTagsResponseDto

    @GET("/products/tags/{id}")
    suspend fun getProductTagDetails(
        @Path("id") tagId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductTagsResponseDto

    @GET("/products/reviews/{id}")
    suspend fun getProductReviewDetails(
        @Path("id") reviewId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): ProductReviewsResponseDto

    // Orders -------------------------------------------------------------------------
    @GET("/orders")
    suspend fun getOrders(
        @Query("page") page: Int = 1,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): OrdersResponseDto

    @GET("/orders/{id}")
    suspend fun getOrderDetails(
        @Path("id") orderId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): OrdersResponseDto

    // Payment GateWays ---------------------------------------------------------------
    @GET("/payment_gateways")
    suspend fun getPaymentGateways(
        @Query("page") page: Int = 1,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/payment_gateways/{id}")
    suspend fun getPaymentGatewayDetails(
        @Path("id") gatewayId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    // Shipping Zones -----------------------------------------------------------------
    @GET("/shipping/zones")
    suspend fun getShippingZones(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    // Customers ---------------------------------------------------------------------
    @GET("/customers/{id}")
    suspend fun getCustomerDetails(
        @Path("id") customerId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    ): CustomersResponseDto

    // Coupons ----------------------------------------------------------------------
    @GET("/coupons")
    suspend fun getCoupons(
        @Query("page") page: Int = 1,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/coupons/{id}")
    suspend fun getCouponDetails(
        @Path("id") couponId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )
}
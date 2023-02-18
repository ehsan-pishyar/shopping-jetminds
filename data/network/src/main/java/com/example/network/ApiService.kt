package com.example.network

import com.example.network.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Products -----------------------------------------------------------------------
    @GET("/products")
    suspend fun getProducts(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/{id}")
    suspend fun getProductById(
        @Path("id") productId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/{product_id}/variations/{id}")
    suspend fun getProductVariationById(
        @Path("product_id") productId: Int,
        @Path("id") variationId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/attributes/{id}")
    suspend fun getProductAttributeById(
        @Path("id") attrId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/categories")
    suspend fun getProductsCategories(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/categories/{id}")
    suspend fun getProductCategoryById(
        @Path("id") categoryId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/shipping_classes/{id}")
    suspend fun getProductShippingClassById(
        @Path("id") shippingClassesId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/tags")
    suspend fun getProductsTags(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/tags/{id}")
    suspend fun getProductTagById(
        @Path("id") tagId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/products/reviews/{id}")
    suspend fun getProductReviewById(
        @Path("id") reviewId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    // Orders -------------------------------------------------------------------------
    @GET("/orders")
    suspend fun getOrders(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/orders/{id}")
    suspend fun getOrderById(
        @Path("id") orderId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    // Payment GateWays ---------------------------------------------------------------
    @GET("/payment_gateways")
    suspend fun getPaymentGateways(
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    @GET("/payment_gateways/{id}")
    suspend fun getPaymentGatewayById(
        @Path("id") gatewayId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    // Shipping Zones -----------------------------------------------------------------
    @GET("/shipping/zones/{id}")
    suspend fun getShippingZoneById(
        @Path("id") zoneId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )

    // Customers ---------------------------------------------------------------------
    @GET("/customers/<id>")
    suspend fun getCustomerById(
        @Path("id") customerId: Int,
        @Query("consumer_key") consumerKey: String = Constants.CONSUMER_KEY,
        @Query("consumer_secret") consumerSecret: String = Constants.CONSUMER_SECRET
    )
}
/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/15/23, 12:04 AM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/10/23, 8:57 PM
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

package com.example.domain.models

data class ProductsResponse(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val dateCreated: String?,
    val type: String?,
    val status: String?,
    val featured: Boolean?,
    val catalogVisibility: String?,
    val description: String?,
    val shortDescription: String?,
    val sku: String?,
    val price: String?,
    val regularPrice: String?,
    val salePrice: String?,
    val dateOnSaleFrom: String?,
    val dateOnSaleTo: String?,
    val onSale: Boolean?,
    val purchasable: Boolean?,
    val totalSales: Int?,
    val taxStatus: String?,
    val taxClass: String?,
    val manageStock: Boolean?,
    val stockQuantity: Int?,
    val soldIndividually: Boolean?,
    val shippingRequired: Boolean?,
    val shippingTaxable: Boolean?,
    val shippingClass: String?,
    val shippingClassId: Int?,
    val reviewsAllowed: Boolean?,
    val averageRating: String?,
    val ratingCount: Int?,
    val categories: List<Category>?,
    val tags: List<Tag>?,
    val images: List<Image>?,
    val attributes: List<Attribute>?,
    val defaultAttributes: List<DefaultAttribute>?,
    val stockStatus: String?,
    val isFavorite: Boolean?,
    val downloaded: Boolean?
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$name",
            "${name?.first()}"
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
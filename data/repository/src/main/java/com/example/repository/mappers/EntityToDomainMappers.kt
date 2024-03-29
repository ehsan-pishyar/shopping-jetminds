/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/14/23, 11:10 PM
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

package com.example.repository.mappers

import com.example.cache.models.*
import com.example.domain.models.*

fun CouponsResponseEntity.toDomain(): CouponsResponse =
    CouponsResponse(
        this.id,
        this.code,
        this.amount,
        this.status,
        this.dateCreated,
        this.dateCreatedGmt,
        this.discountType,
        this.description,
        this.dateExpires,
        this.dateExpiresGmt,
        this.usageCount,
        this.individualUse,
        this.productIds?.map { it },
        this.excludedProductIds?.map { it },
        this.usageLimit,
        this.usageLimitPerUser,
        this.limitUsageToXItems,
        this.freeShipping,
        this.productCategories?.map { it.toDomain() },
        this.excludeSaleItems,
        this.maximumAmount,
        this.minimumAmount,
        this.emailRestrictions
    )

fun OrdersResponseEntity.toDomain(): OrdersResponse =
    OrdersResponse(
        this.id,
        this.parentId,
        this.status,
        this.currency,
        this.pricesIncludeTax,
        this.dateCreated,
        this.dateModified,
        this.discountTotal,
        this.discountTax,
        this.shippingTotal,
        this.shippingTax,
        this.cartTax,
        this.total,
        this.totalTax,
        this.customerId,
        this.orderKey,
        this.billing?.toDomain(),
        this.shipping?.toDomain(),
        this.paymentMethod,
        this.paymentMethodTitle,
        this.transactionId,
        this.customerIpAddress,
        this.customerNote,
        this.dateCompleted,
        this.datePaid,
        this.cartHash,
        this.number,
        this.lineItems?.map { it.toDomain() },
        this.taxLines?.map { it.toDomain() },
        this.shippingLines?.map { it.toDomain() },
        this.paymentUrl,
        this.dateCreatedGmt,
        this.dateModifiedGmt,
        this.dateCompletedGmt,
        this.datePaidGmt,
        this.currencySymbol
    )

fun ProductAttributesResponseEntity.toDomain(): ProductAttributesResponse =
    ProductAttributesResponse(
        this.id,
        this.name,
        this.slug,
        this.type,
        this.orderBy,
        this.hasArchives
    )

fun ProductCategoriesResponseEntity.toDomain(): ProductCategoriesResponse =
    ProductCategoriesResponse(
        this.id,
        this.name,
        this.slug,
        this.parent,
        this.description,
        this.display,
        this.image?.toDomain(),
        this.menuOrder,
        this.count
    )

fun ProductReviewsResponseEntity.toDomain(): ProductReviewsResponse =
    ProductReviewsResponse(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.productId,
        this.status,
        this.reviewer,
        this.reviewerEmail,
        this.review,
        this.rating,
        this.verified,
        this.avatar?.toDomain()
    )

fun ProductShippingClassesResponseEntity.toDomain(): ProductShippingClassesResponse =
    ProductShippingClassesResponse(
        this.id,
        this.name,
        this.slug,
        this.description,
        this.count
    )

fun ProductsResponseEntity.toDomain(): ProductsResponse =
    ProductsResponse(
        this.id,
        this.name,
        this.slug,
        this.dateCreated,
        this.type,
        this.status,
        this.featured,
        this.catalogVisibility,
        this.description,
        this.shortDescription,
        this.sku,
        this.price,
        this.regularPrice,
        this.salePrice,
        this.dateOnSaleFrom,
        this.dateOnSaleTo,
        this.onSale,
        this.purchasable,
        this.totalSales,
        this.taxStatus,
        this.taxClass,
        this.manageStock,
        this.stockQuantity,
        this.soldIndividually,
        this.shippingRequired,
        this.shippingTaxable,
        this.shippingClass,
        this.shippingClassId,
        this.reviewsAllowed,
        this.averageRating,
        this.ratingCount,
        this.categories?.map { it.toDomain() },
        this.tags?.map { it.toDomain() },
        this.images?.map { it.toDomain() },
        this.attributes?.map { it.toDomain() },
        this.defaultAttributes?.map { it.toDomain() },
        this.stockStatus,
        this.isFavorite,
        this.downloaded
    )

fun ProductTagsResponseEntity.toDomain(): ProductTagsResponse =
    ProductTagsResponse(
        this.id,
        this.name,
        this.slug,
        this.description,
        this.count
    )

fun ProductVariationsResponseEntity.toDomain(): ProductVariationsResponse =
    ProductVariationsResponse(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.description,
        this.permalink,
        this.sku,
        this.price,
        this.regularPrice,
        this.salePrice,
        this.dateOnSaleFrom,
        this.dateOnSaleFromGmt,
        this.dateOnSaleTo,
        this.dateOnSaleToGmt,
        this.onSale,
        this.status,
        this.purchasable,
        this.taxStatus,
        this.taxClass,
        this.manageStock,
        this.stockQuantity,
        this.stockStatus,
        this.shippingClass,
        this.shippingClassId,
        this.image?.toDomain(),
        this.attributes?.map { it.toDomain() }
    )

fun ShippingZonesResponseEntity.toDomain(): ShippingZonesResponse =
    ShippingZonesResponse(
        this.id,
        this.name,
        this.order
    )

fun AttributeEntity.toDomain(): Attribute =
    Attribute(
        this.id,
        this.name,
        this.options,
        this.position,
        this.variation,
        this.visible
    )

fun BillingEntity.toDomain(): Billing =
    Billing(
        this.address1,
        this.address2,
        this.city,
        this.company,
        this.country,
        this.email,
        this.firstName,
        this.lastName,
        this.phone,
        this.postcode,
        this.state
    )

fun CategoryEntity.toDomain(): Category =
    Category(
        this.id,
        this.name
    )

fun DefaultAttributeEntity.toDomain(): DefaultAttribute =
    DefaultAttribute(
        this.id,
        this.name,
        this.option
    )

fun ImageEntity.toDomain(): Image =
    Image(
        this.id,
        this.name,
        this.src,
        this.alt
    )

fun LineItemEntity.toDomain(): LineItem = LineItem(
    this.id,
    this.name,
    this.price,
    this.productId,
    this.quantity,
    this.sku,
    this.subtotal,
    this.subtotalTax,
    this.taxClass,
    this.taxes?.map { it.toDomain() },
    this.total,
    this.totalTax,
    this.variationId
)

fun ShippingEntity.toDomain(): Shipping =
    Shipping(
        this.address1,
        this.address2,
        this.city,
        this.company,
        this.country,
        this.firstName,
        this.lastName,
        this.postcode,
        this.state
    )

fun ShippingLineEntity.toDomain(): ShippingLine =
    ShippingLine(
        this.id,
        this.methodId,
        this.methodTitle,
        this.taxes?.map { it.toDomain() },
        this.total,
        this.totalTax
    )

fun TagEntity.toDomain(): Tag =
    Tag(
        this.id,
        this.name
    )

fun TaxEntity.toDomain(): Tax =
    Tax(
        this.id,
        this.subtotal,
        this.total
    )

fun TaxLineEntity.toDomain(): TaxLine =
    TaxLine(
        this.id,
        this.label,
        this.compound,
        this.rateCode,
        this.rateId,
        this.shippingTaxTotal,
        this.taxTotal
    )

fun CustomersResponseEntity.toDomain(): CustomersResponse =
    CustomersResponse(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.email,
        this.firstName,
        this.lastName,
        this.role,
        this.username,
        this.billing?.toDomain(),
        this.shipping?.toDomain(),
        this.isPayingCustomer,
        this.avatarUrl
    )

fun UserAvatarEntity.toDomain(): UserAvatar =
    UserAvatar(
        this.size24,
        this.size48,
        this.size96
    )

fun CartEntity.toDomain(): Cart =
    Cart(
        this.productId,
        this.productTitle,
        this.productImage,
        this.productCategory,
        this.productPrice,
        this.dateAdded,
        this.itemCount
    )

fun PaymentGatewaysResponseEntity.toDomain(): PaymentGatewaysResponse =
    PaymentGatewaysResponse(
        this.id,
        this.title,
        this.description,
        this.order,
        this.enabled,
        this.methodTitle,
        this.methodDescription,
        this.methodSupports,
        this.settings?.toDomain(),
        this.needsSetup,
        this.settingsUrl,
        this.connectionUrl,
        this.setupHelpText
    )

fun SettingsEntity.toDomain(): Settings =
    Settings(
        this.baseConfig?.toDomain(),
        this.title?.toDomain(),
        this.accountConfig?.toDomain(),
        this.api?.toDomain(),
        this.merchantCode?.toDomain(),
        this.webServiceConfig?.toDomain(),
        this.apiKey?.toDomain(),
        this.successMassage?.toDomain(),
        this.failedMassage?.toDomain()
    )

fun PaymentMessageEntity.toDomain(): PaymentMessage =
    PaymentMessage(
        this.id,
        this.label,
        this.description,
        this.type,
        this.value,
        this.default,
        this.tip,
        this.placeholder
    )
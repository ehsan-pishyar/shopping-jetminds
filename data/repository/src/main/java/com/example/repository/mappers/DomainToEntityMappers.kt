package com.example.repository.mappers

import com.example.cache.models.AttributeEntity
import com.example.cache.models.BillingEntity
import com.example.cache.models.CartEntity
import com.example.cache.models.CategoryEntity
import com.example.cache.models.CustomersResponseEntity
import com.example.cache.models.DefaultAttributeEntity
import com.example.cache.models.ImageEntity
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.models.ShippingEntity
import com.example.cache.models.TagEntity
import com.example.domain.models.Attribute
import com.example.domain.models.Billing
import com.example.domain.models.Cart
import com.example.domain.models.Category
import com.example.domain.models.CustomersResponse
import com.example.domain.models.DefaultAttribute
import com.example.domain.models.Image
import com.example.domain.models.ProductsResponse
import com.example.domain.models.Shipping
import com.example.domain.models.Tag

fun ProductsResponse.toEntity(): ProductsResponseEntity =
    ProductsResponseEntity(
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
        this.categories?.map { it.toEntity() },
        this.tags?.map { it.toEntity() },
        this.images?.map { it.toEntity() },
        this.attributes?.map { it.toEntity() },
        this.defaultAttributes?.map { it.toEntity() },
        this.stockStatus,
        this.isFavorite,
        this.downloaded
    )

fun Category.toEntity(): CategoryEntity =
    CategoryEntity(
        this.id,
        this.name
    )

fun Tag.toEntity(): TagEntity =
    TagEntity(
        this.id,
        this.name
    )

fun Image.toEntity(): ImageEntity =
    ImageEntity(
        this.id,
        this.name,
        this.src,
        this.alt
    )

fun Attribute.toEntity(): AttributeEntity =
    AttributeEntity(
        this.id,
        this.name,
        this.options,
        this.position,
        this.variation,
        this.visible
    )

fun DefaultAttribute.toEntity(): DefaultAttributeEntity =
    DefaultAttributeEntity(
        this.id,
        this.name,
        this.option
    )

fun CustomersResponse.toEntity(): CustomersResponseEntity =
    CustomersResponseEntity(
        this.id,
        this.dateCreated,
        this.dateCreatedGmt,
        this.email,
        this.firstName,
        this.lastName,
        this.role,
        this.username,
        this.billing?.toEntity(),
        this.shipping?.toEntity(),
        this.isPayingCustomer,
        this.avatarUrl
    )

fun Billing.toEntity(): BillingEntity =
    BillingEntity(
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

fun Shipping.toEntity(): ShippingEntity =
    ShippingEntity(
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

fun Cart.toEntity(): CartEntity =
    CartEntity(
        this.productId,
        this.productTitle,
        this.productImage,
        this.productCategory,
        this.productPrice,
        this.dateAdded,
        this.itemCount
    )
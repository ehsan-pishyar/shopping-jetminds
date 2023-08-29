package com.example.repository.mappers

import com.example.cache.models.AttributeEntity
import com.example.cache.models.CartEntity
import com.example.cache.models.CategoryEntity
import com.example.cache.models.DefaultAttributeEntity
import com.example.cache.models.ImageEntity
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.models.TagEntity
import com.example.domain.models.Attribute
import com.example.domain.models.Cart
import com.example.domain.models.Category
import com.example.domain.models.DefaultAttribute
import com.example.domain.models.Image
import com.example.domain.models.ProductsResponse
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
        this.isFavorite
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

fun Cart.toEntity(): CartEntity =
    CartEntity(
        this.cartId,
        this.count,
        this.items?.map { it.toEntity() }
    )
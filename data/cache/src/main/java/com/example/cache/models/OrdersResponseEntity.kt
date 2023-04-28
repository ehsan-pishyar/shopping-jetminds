package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.ORDERS_TABLE)
data class OrdersResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @ColumnInfo(name = "parent_id")
    val parentId: Int? = null,
    val status: String? = null,
    val currency: String? = null,
    @ColumnInfo(name = "prices_include_tax")
    val pricesIncludeTax: Boolean? = null,
    @ColumnInfo(name = "date_created")
    val dateCreated: String? = null,
    @ColumnInfo(name = "date_modified")
    val dateModified: String? = null,
    @ColumnInfo(name = "discount_total")
    val discountTotal: String? = null,
    @ColumnInfo(name = "discount_tax")
    val discountTax: String? = null,
    @ColumnInfo(name = "shipping_total")
    val shippingTotal: String? = null,
    @ColumnInfo(name = "shipping_tax")
    val shippingTax: String? = null,
    @ColumnInfo(name = "cart_tax")
    val cartTax: String? = null,
    val total: String? = null,
    @ColumnInfo(name = "total_tax")
    val totalTax: String? = null,
    @ColumnInfo(name = "customer_id")
    val customerId: Int? = null,
    @ColumnInfo(name = "order_key")
    val orderKey: String? = null,
    val billing: BillingEntity? = null,
    val shipping: ShippingEntity? = null,
    @ColumnInfo(name = "payment_method")
    val paymentMethod: String? = null,
    @ColumnInfo(name = "payment_method_title")
    val paymentMethodTitle: String? = null,
    @ColumnInfo(name = "transaction_id")
    val transactionId: String? = null,
    @ColumnInfo(name = "customer_ip_address")
    val customerIpAddress: String? = null,
    @ColumnInfo(name = "customer_note")
    val customerNote: String? = null,
    @ColumnInfo(name = "date_completed")
    val dateCompleted: String? = null,
    @ColumnInfo(name = "date_paid")
    val datePaid: String? = null,
    @ColumnInfo(name = "cart_hash")
    val cartHash: String? = null,
    val number: String? = null,
    @ColumnInfo(name = "line_items")
    val lineItems: List<LineItemEntity>? = null,
    @ColumnInfo(name = "tax_lines")
    val taxLines: List<TaxLineEntity>? = null,
    @ColumnInfo(name = "shipping_lines")
    val shippingLines: List<ShippingLineEntity>? = null,
    @ColumnInfo(name = "payment_url")
    val paymentUrl: String? = null,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    @ColumnInfo(name = "date_modified_gmt")
    val dateModifiedGmt: String? = null,
    @ColumnInfo(name = "date_completed_gmt")
    val dateCompletedGmt: String? = null,
    @ColumnInfo(name = "date_paid_gmt")
    val datePaidGmt: String? = null,
    @ColumnInfo(name = "currency_symbol")
    val currencySymbol: String? = null
)
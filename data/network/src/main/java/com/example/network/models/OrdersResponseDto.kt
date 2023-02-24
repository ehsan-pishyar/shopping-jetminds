package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersResponseDto(
    val id: Int,
    @SerialName("parent_id")
    val parentId: Int,
    val status: String,
    val currency: String,
    @SerialName("prices_include_tax")
    val pricesIncludeTax: Boolean,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_modified")
    val dateModified: String,
    @SerialName("discount_total")
    val discountTotal: String,
    @SerialName("discount_tax")
    val discountTax: String,
    @SerialName("shipping_total")
    val shippingTotal: String,
    @SerialName("shipping_tax")
    val shippingTax: String,
    @SerialName("cart_tax")
    val cartTax: String,
    val total: String,
    @SerialName("total_tax")
    val totalTax: String,
    @SerialName("customer_id")
    val customerId: Int,
    @SerialName("order_key")
    val orderKey: String,
    val billing: BillingDto,
    val shipping: ShippingDto,
    @SerialName("payment_method")
    val paymentMethod: String,
    @SerialName("payment_method_title")
    val paymentMethodTitle: String,
    @SerialName("transaction_id")
    val transactionId: String,
    @SerialName("customer_ip_address")
    val customerIpAddress: String,
    @SerialName("customer_note")
    val customerNote: String,
    @SerialName("date_completed")
    val dateCompleted: String,
    @SerialName("date_paid")
    val datePaid: String,
    @SerialName("cart_hash")
    val cartHash: String,
    val number: String,
    @SerialName("line_items")
    val lineItems: List<LineItemDto>,
    @SerialName("tax_lines")
    val taxLines: List<TaxLineDto>,
    @SerialName("shipping_lines")
    val shippingLines: List<ShippingLineDto>,
    @SerialName("payment_url")
    val paymentUrl: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String,
    @SerialName("date_modified_gmt")
    val dateModifiedGmt: String,
    @SerialName("date_completed_gmt")
    val dateCompletedGmt: String,
    @SerialName("date_paid_gmt")
    val datePaidGmt: String,
    @SerialName("currency_symbol")
    val currencySymbol: String
)
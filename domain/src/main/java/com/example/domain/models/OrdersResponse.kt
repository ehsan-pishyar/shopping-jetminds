package com.example.domain.models

data class OrdersResponse(
    val id: Int,
    val parentId: Int,
    val status: String,
    val currency: String,
    val pricesIncludeTax: Boolean,
    val dateCreated: String,
    val dateModified: String,
    val discountTotal: String,
    val discountTax: String,
    val shippingTotal: String,
    val shippingTax: String,
    val cartTax: String,
    val total: String,
    val totalTax: String,
    val customerId: Int,
    val orderKey: String,
    val billing: Billing,
    val shipping: Shipping,
    val paymentMethod: String,
    val paymentMethodTitle: String,
    val transactionId: String,
    val customerIpAddress: String,
    val customerNote: String,
    val dateCompleted: String,
    val datePaid: String,
    val cartHash: String,
    val number: String,
    val lineItems: List<LineItem>,
    val taxLines: List<TaxLine>,
    val shippingLines: List<ShippingLine>,
    val paymentUrl: String,
    val dateCreatedGmt: String,
    val dateModifiedGmt: String,
    val dateCompletedGmt: String,
    val datePaidGmt: String,
    val currencySymbol: String
)
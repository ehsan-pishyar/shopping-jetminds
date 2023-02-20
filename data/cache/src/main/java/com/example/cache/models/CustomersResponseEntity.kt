package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.CUSTOMERS_TABLE)
data class CustomersResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "date_created")
    val dateCreated: String,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreated_gmt: String,
    val email: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val role: String,
    val username: String,
    @ColumnInfo(name = "billing")
    val billingEntity: BillingEntity,
    @ColumnInfo(name = "shipping")
    val shippingEntity: ShippingEntity,
    @ColumnInfo(name = "is_paying_customer")
    val isPayingCustomer: Boolean,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String
)
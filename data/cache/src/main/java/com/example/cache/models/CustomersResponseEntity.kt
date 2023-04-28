package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.CUSTOMERS_TABLE)
data class CustomersResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @ColumnInfo(name = "date_created")
    val dateCreated: String? = null,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    val email: String? = null,
    @ColumnInfo(name = "first_name")
    val firstName: String? = null,
    @ColumnInfo(name = "last_name")
    val lastName: String? = null,
    val role: String? = null,
    val username: String? = null,
    val billing: BillingEntity? = null,
    val shipping: ShippingEntity? = null,
    @ColumnInfo(name = "is_paying_customer")
    val isPayingCustomer: Boolean? = null,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String? = null
)
package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PAYMENT_GATEWAYS_TABLE)
data class PaymentGatewaysResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String?,
    val description: String?,
    val order: String?,
    val enabled: Boolean?,
    @ColumnInfo(name = "method_title")
    val methodTitle: String?,
    @ColumnInfo(name = "method_description")
    val methodDescription: String?,
    @ColumnInfo(name = "method_supports")
    val methodSupports: List<String>?,
    @ColumnInfo(name = "connection_url")
    val settings: SettingsEntity?,
    @ColumnInfo(name = "needs_setup")
    val needsSetup: Boolean?,
    @ColumnInfo(name = "settings_url")
    val settingsUrl: String?,
    val connectionUrl: String?,
    @ColumnInfo(name = "setup_help_text")
    val setupHelpText: String?
)
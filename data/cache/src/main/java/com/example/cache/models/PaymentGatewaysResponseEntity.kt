/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/15/23, 9:19 PM
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
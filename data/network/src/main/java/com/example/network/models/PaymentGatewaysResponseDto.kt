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

package com.example.network.models

import com.google.gson.annotations.SerializedName

data class PaymentGatewaysResponseDto(
    val id: String,
    val title: String?,
    val description: String?,
    val order: String?,
    val enabled: Boolean?,
    @SerializedName("method_title")
    val methodTitle: String?,
    @SerializedName("method_description")
    val methodDescription: String?,
    @SerializedName("method_supports")
    val methodSupports: List<String>?,
    @SerializedName("connection_url")
    val settings: SettingsDto?,
    @SerializedName("needs_setup")
    val needsSetup: Boolean?,
    @SerializedName("settings_url")
    val settingsUrl: String?,
    val connectionUrl: String?,
    @SerializedName("setup_help_text")
    val setupHelpText: String?
)
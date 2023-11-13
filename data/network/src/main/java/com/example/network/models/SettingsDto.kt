/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/14/23, 10:53 PM
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

data class SettingsDto(
    @SerializedName("base_confing")
    val baseConfig: PaymentMessageDto?,
    val title: PaymentMessageDto?,
    @SerializedName("account_confing")
    val accountConfig: PaymentMessageDto?,
    val api: PaymentMessageDto?,
    @SerializedName("merchantcode")
    val merchantCode: PaymentMessageDto?,
    @SerializedName("webservice_config")
    val webServiceConfig: PaymentMessageDto?,
    @SerializedName("api_key")
    val apiKey: PaymentMessageDto?,
    @SerializedName("success_massage")
    val successMassage: PaymentMessageDto?,
    @SerializedName("failed_massage")
    val failedMassage: PaymentMessageDto?
)
/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:29 PM
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

data class ShippingLineDto(
    val id: Int?,
    @SerializedName("method_id")
    val methodId: String?,
    @SerializedName("method_title")
    val methodTitle: String?,
    val taxes: List<TaxDto>?,
    val total: String?,
    @SerializedName("total_tax")
    val totalTax: String?
)
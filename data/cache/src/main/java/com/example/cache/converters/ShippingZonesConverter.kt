/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/28/23, 12:15 AM
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

package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingZonesResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShippingZonesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(shippingZoneEntity: ShippingZonesResponseEntity?): String?{
        if (shippingZoneEntity== null) return null

        val type = object : TypeToken<ShippingZonesResponseEntity?>() {}.type
        return gson.toJson(shippingZoneEntity, type)
    }

    @TypeConverter
    fun to(shippingZoneItem: String?): ShippingZonesResponseEntity?{
        if (shippingZoneItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ShippingZonesResponseEntity?>() {}.type
        return gson.fromJson(shippingZoneItem, type)
    }
}
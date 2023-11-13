/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/28/23, 12:17 AM
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
import com.example.cache.models.TagEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TagsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(tagsEntity: List<TagEntity>?): String?{
        if (tagsEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TagEntity>?>() {}.type
        return gson.toJson(tagsEntity, type)
    }

    @TypeConverter
    fun to(tagsItem: String?): List<TagEntity>?{
        if (tagsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TagEntity>?>() {}.type
        return gson.fromJson(tagsItem, type)
    }
}
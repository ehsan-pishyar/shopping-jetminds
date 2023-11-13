/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/28/23, 10:21 PM
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

package com.example.core.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.models.ProductsResponse

class SharedViewModel: ViewModel() {

    var productState by mutableStateOf<ProductsResponse?>(null)
        private set

    var categoryId by mutableStateOf(0)
        private set

    var productId by mutableStateOf(0)
        private set

    fun addProduct(product: ProductsResponse) {
        productState = product
    }

    fun addCategoryId(id: Int) {
        categoryId = id
    }

    fun addProductId(id: Int) {
        productId = id
    }
}
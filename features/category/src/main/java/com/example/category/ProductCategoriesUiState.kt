/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/19/23, 10:07 PM
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

package com.example.category

import com.example.domain.models.ProductCategoriesResponse

sealed interface ProductCategoriesUiState {
    object Loading: ProductCategoriesUiState
    data class Success(val categories: List<ProductCategoriesResponse>): ProductCategoriesUiState
    data class Error(val message: String): ProductCategoriesUiState
}

sealed interface ProductCategoryDetailsUiState {
    object Loading: ProductCategoryDetailsUiState
    data class Success(val categoryDetails: ProductCategoriesResponse):
        ProductCategoryDetailsUiState
    data class Error(val message: String): ProductCategoryDetailsUiState
}

data class MainProductCategoriesUiState(
    val categoriesUiState: ProductCategoriesUiState
)

data class MainProductCategoryDetailsUiState(
    val categoryDetailsUiState: ProductCategoryDetailsUiState
)
/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/1/23, 8:45 PM
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

package com.example.domain.use_cases.product_categories

import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow
import com.example.domain.utils.ServiceResult

class GetProductCategoryDetailsUseCase constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
) {

    operator fun invoke(categoryId: Int): Flow<ServiceResult<ProductCategoriesResponse>> =
        productCategoriesRepository.getProductCategoryDetails(categoryId).asResult()
}
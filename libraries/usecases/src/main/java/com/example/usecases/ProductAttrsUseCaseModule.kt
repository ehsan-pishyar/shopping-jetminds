/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/3/23, 11:50 PM
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

package com.example.usecases

import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductAttrsUseCaseModule {

    @Provides
    fun providesGetProductAttrsUseCase(
        repository: ProductAttributesRepository
    ): GetProductAttrsUseCase = GetProductAttrsUseCase(repository)

    @Provides
    fun providesGetProductAttrDetailsUseCase(
        repository: ProductAttributesRepository
    ): GetProductAttrDetailsUseCase = GetProductAttrDetailsUseCase(repository)
}
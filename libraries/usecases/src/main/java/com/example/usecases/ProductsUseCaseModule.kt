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

import com.example.domain.repositories.ProductsRepository
import com.example.domain.use_cases.products.GetHighestPriceProductsUseCase
import com.example.domain.use_cases.products.GetLowestPriceProductsUseCase
import com.example.domain.use_cases.products.GetNewestProductsUseCase
import com.example.domain.use_cases.products.GetOnSaleProductsUseCase
import com.example.domain.use_cases.products.GetPopularProductsUseCase
import com.example.domain.use_cases.products.GetProductDetailsUseCase
import com.example.domain.use_cases.products.GetProductsByAttrIdUseCase
import com.example.domain.use_cases.products.GetProductsByCategoryIdUseCase
import com.example.domain.use_cases.products.GetProductsByTagIdUseCase
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.use_cases.products.GetTopRatedProductsUseCase
import com.example.domain.use_cases.products.GetTopSalesProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductsUseCaseModule {

    @Provides
    fun providesGetNewestProductsUseCase(
        repository: ProductsRepository
    ): GetNewestProductsUseCase = GetNewestProductsUseCase(repository = repository)

    @Provides
    fun providesGetOnSaleProductsUseCase(
        repository: ProductsRepository
    ): GetOnSaleProductsUseCase = GetOnSaleProductsUseCase(repository = repository)

    @Provides
    fun providesGetPopularProductsUseCase(
        repository: ProductsRepository
    ): GetPopularProductsUseCase = GetPopularProductsUseCase(repository = repository)

    @Provides
    fun providesGetTopRatedProductsUseCase(
        repository: ProductsRepository
    ): GetTopRatedProductsUseCase = GetTopRatedProductsUseCase(repository = repository)

    @Provides
    fun providesGetTopSalesProductsUseCase(
        repository: ProductsRepository
    ): GetTopSalesProductsUseCase = GetTopSalesProductsUseCase(repository = repository)

    @Provides
    fun providesGetLowestPriceProductsUseCase(
        repository: ProductsRepository
    ): GetLowestPriceProductsUseCase = GetLowestPriceProductsUseCase(repository = repository)

    @Provides
    fun providesGetHighestPriceProductsUseCase(
        repository: ProductsRepository
    ): GetHighestPriceProductsUseCase = GetHighestPriceProductsUseCase(repository = repository)

    @Provides
    fun providesGetProductsUseCase(
        repository: ProductsRepository
    ): GetProductsUseCase = GetProductsUseCase(repository = repository)

    @Provides
    fun providesGetProductDetailsUseCase(
        repository: ProductsRepository
    ): GetProductDetailsUseCase = GetProductDetailsUseCase(repository = repository)

    @Provides
    fun providesGetProductsByAttrIdUseCase(
        repository: ProductsRepository
    ): GetProductsByAttrIdUseCase = GetProductsByAttrIdUseCase(repository = repository)

    @Provides
    fun providesGetProductsByCategoryIdUseCase(
        repository: ProductsRepository
    ): GetProductsByCategoryIdUseCase = GetProductsByCategoryIdUseCase(repository = repository)

    @Provides
    fun providesGetProductsByTagIdUseCase(
        repository: ProductsRepository
    ): GetProductsByTagIdUseCase = GetProductsByTagIdUseCase(repository = repository)
}
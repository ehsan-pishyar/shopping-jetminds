package com.example.repository.di

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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsUseCaseModule {

    @[Provides Singleton]
    fun providesGetNewestProductsUseCase(
        repository: ProductsRepository
    ): GetNewestProductsUseCase = GetNewestProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetOnSaleProductsUseCase(
        repository: ProductsRepository
    ): GetOnSaleProductsUseCase = GetOnSaleProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetPopularProductsUseCase(
        repository: ProductsRepository
    ): GetPopularProductsUseCase = GetPopularProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetTopRatedProductsUseCase(
        repository: ProductsRepository
    ): GetTopRatedProductsUseCase = GetTopRatedProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetTopSalesProductsUseCase(
        repository: ProductsRepository
    ): GetTopSalesProductsUseCase = GetTopSalesProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetLowestPriceProductsUseCase(
        repository: ProductsRepository
    ): GetLowestPriceProductsUseCase = GetLowestPriceProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetHighestPriceProductsUseCase(
        repository: ProductsRepository
    ): GetHighestPriceProductsUseCase = GetHighestPriceProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductsUseCase(
        repository: ProductsRepository
    ): GetProductsUseCase = GetProductsUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductDetailsUseCase(
        repository: ProductsRepository
    ): GetProductDetailsUseCase = GetProductDetailsUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductsByAttrIdUseCase(
        repository: ProductsRepository
    ): GetProductsByAttrIdUseCase = GetProductsByAttrIdUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductsByCategoryIdUseCase(
        repository: ProductsRepository
    ): GetProductsByCategoryIdUseCase = GetProductsByCategoryIdUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductsByTagIdUseCase(
        repository: ProductsRepository
    ): GetProductsByTagIdUseCase = GetProductsByTagIdUseCase(repository)
}
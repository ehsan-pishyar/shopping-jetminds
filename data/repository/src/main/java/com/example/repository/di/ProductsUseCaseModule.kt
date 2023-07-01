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

@Module
@InstallIn(SingletonComponent::class)
object ProductsUseCaseModule {

    @Provides
    fun providesGetNewestProductsUseCase(
        repository: ProductsRepository
    ): GetNewestProductsUseCase = GetNewestProductsUseCase(repository)

    @Provides
    fun providesGetOnSaleProductsUseCase(
        repository: ProductsRepository
    ): GetOnSaleProductsUseCase = GetOnSaleProductsUseCase(repository)

    @Provides
    fun providesGetPopularProductsUseCase(
        repository: ProductsRepository
    ): GetPopularProductsUseCase = GetPopularProductsUseCase(repository)

    @Provides
    fun providesGetTopRatedProductsUseCase(
        repository: ProductsRepository
    ): GetTopRatedProductsUseCase = GetTopRatedProductsUseCase(repository)

    @Provides
    fun providesGetTopSalesProductsUseCase(
        repository: ProductsRepository
    ): GetTopSalesProductsUseCase = GetTopSalesProductsUseCase(repository)

    @Provides
    fun providesGetLowestPriceProductsUseCase(
        repository: ProductsRepository
    ): GetLowestPriceProductsUseCase = GetLowestPriceProductsUseCase(repository)

    @Provides
    fun providesGetHighestPriceProductsUseCase(
        repository: ProductsRepository
    ): GetHighestPriceProductsUseCase = GetHighestPriceProductsUseCase(repository)

    @Provides
    fun providesGetProductsUseCase(
        repository: ProductsRepository
    ): GetProductsUseCase = GetProductsUseCase(repository)

    @Provides
    fun providesGetProductDetailsUseCase(
        repository: ProductsRepository
    ): GetProductDetailsUseCase = GetProductDetailsUseCase(repository)

    @Provides
    fun providesGetProductsByAttrIdUseCase(
        repository: ProductsRepository
    ): GetProductsByAttrIdUseCase = GetProductsByAttrIdUseCase(repository)

    @Provides
    fun providesGetProductsByCategoryIdUseCase(
        repository: ProductsRepository
    ): GetProductsByCategoryIdUseCase = GetProductsByCategoryIdUseCase(repository)

    @Provides
    fun providesGetProductsByTagIdUseCase(
        repository: ProductsRepository
    ): GetProductsByTagIdUseCase = GetProductsByTagIdUseCase(repository)
}
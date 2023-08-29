package com.example.repository.di

import com.example.domain.repositories.ProductsRepository
import com.example.domain.use_cases.products.GetFavoriteProductsUseCase
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
import com.example.domain.use_cases.products.UpdateFavoriteProductUseCase
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

    @Provides
    fun providesGetFavoriteProductsUseCase(
        repository: ProductsRepository
    ): GetFavoriteProductsUseCase = GetFavoriteProductsUseCase(repository = repository)

    @Provides
    fun providesUpdateFavoriteProductUseCase(
        repository: ProductsRepository
    ): UpdateFavoriteProductUseCase = UpdateFavoriteProductUseCase(repository = repository)
}
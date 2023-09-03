package com.example.usecases

import com.example.domain.repositories.CartRepository
import com.example.domain.use_cases.cart.ClearCartUseCase
import com.example.domain.use_cases.cart.DeleteCartItemUseCase
import com.example.domain.use_cases.cart.GetCartItemsUseCase
import com.example.domain.use_cases.cart.InsertCartItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CartUseCaseModule {

    @Provides
    fun providesGetCartItemsUseCase(
        repository: CartRepository
    ): GetCartItemsUseCase = GetCartItemsUseCase(repository = repository)

    @Provides
    fun providesInsertCartItemsUseCase(
        repository: CartRepository
    ): InsertCartItemUseCase = InsertCartItemUseCase(repository = repository)

    @Provides
    fun providesClearCartUseCase(
        repository: CartRepository
    ): ClearCartUseCase = ClearCartUseCase(repository = repository)

    @Provides
    fun providesDeleteCartItemUseCase(
        repository: CartRepository
    ): DeleteCartItemUseCase = DeleteCartItemUseCase(repository = repository)
}
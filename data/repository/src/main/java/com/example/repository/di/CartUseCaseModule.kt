package com.example.repository.di

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
        impl: CartRepository
    ): GetCartItemsUseCase = GetCartItemsUseCase(repository = impl)

    @Provides
    fun providesInsertCartItemsUseCase(
        impl: CartRepository
    ): InsertCartItemUseCase = InsertCartItemUseCase(repository = impl)

    @Provides
    fun providesClearCartUseCase(
        impl: CartRepository
    ): ClearCartUseCase = ClearCartUseCase(repository = impl)

    @Provides
    fun providesDeleteCartItemUseCase(
        impl: CartRepository
    ): DeleteCartItemUseCase = DeleteCartItemUseCase(repository = impl)
}
package com.example.usecases

import com.example.domain.repositories.CartRepository
import com.example.domain.use_cases.cart.GetCartItemsUseCase
import com.example.domain.use_cases.cart.IsInCartUseCase
import com.example.domain.use_cases.cart.ItemCountInCartUseCase
import com.example.domain.use_cases.cart.UpdateCartItemUseCase
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
    fun providesUpdateCartItemUseCase(
        repository: CartRepository
    ): UpdateCartItemUseCase = UpdateCartItemUseCase(repository = repository)

    @Provides
    fun providesIsInCartUseCase(
        repository: CartRepository
    ): IsInCartUseCase = IsInCartUseCase(repository = repository)

    @Provides
    fun providesItemCountInCart(
        repository: CartRepository
    ): ItemCountInCartUseCase = ItemCountInCartUseCase(repository = repository)
}
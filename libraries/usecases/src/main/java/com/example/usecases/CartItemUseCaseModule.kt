package com.example.usecases

import com.example.domain.repositories.CartItemRepository
import com.example.domain.use_cases.cart_item.ClearCartUseCase
import com.example.domain.use_cases.cart_item.DeleteCartItemUseCase
import com.example.domain.use_cases.cart_item.GetCartItemCountUseCase
import com.example.domain.use_cases.cart_item.GetCartItemsUseCase
import com.example.domain.use_cases.cart_item.GetCartTotalCountsUseCase
import com.example.domain.use_cases.cart_item.GetCartTotalPricesUseCase
import com.example.domain.use_cases.cart_item.InsertCartItemUseCase
import com.example.domain.use_cases.cart_item.IsInCartItemUseCase
import com.example.domain.use_cases.cart_item.UpdateCartItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CartItemUseCaseModule {

    @Provides
    fun providesInsertItemUseCase(
        repository: CartItemRepository
    ): InsertCartItemUseCase = InsertCartItemUseCase(repository = repository)

    @Provides
    fun providesUpdateCartItemUseCase(
        repository: CartItemRepository
    ): UpdateCartItemUseCase = UpdateCartItemUseCase(repository = repository)

    @Provides
    fun providesGetCartItemsUseCase(
        repository: CartItemRepository
    ): GetCartItemsUseCase = GetCartItemsUseCase(repository = repository)

    @Provides
    fun providesGetCartTotalPricesUseCase(
        repository: CartItemRepository
    ): GetCartTotalPricesUseCase = GetCartTotalPricesUseCase(repository = repository)

    @Provides
    fun providesGetCartTotalCountsUseCase(
        repository: CartItemRepository
    ): GetCartTotalCountsUseCase = GetCartTotalCountsUseCase(repository = repository)

    @Provides
    fun providesGetCartItemCountUseCase(
        repository: CartItemRepository
    ): GetCartItemCountUseCase = GetCartItemCountUseCase(repository = repository)

    @Provides
    fun providesIsInCartItemUseCase(
        repository: CartItemRepository
    ): IsInCartItemUseCase = IsInCartItemUseCase(repository = repository)

    @Provides
    fun providesDeleteCartItem(
        repository: CartItemRepository
    ): DeleteCartItemUseCase = DeleteCartItemUseCase(repository = repository)

    @Provides
    fun providesClearCartUseCase(
        repository: CartItemRepository
    ): ClearCartUseCase = ClearCartUseCase(repository = repository)
}
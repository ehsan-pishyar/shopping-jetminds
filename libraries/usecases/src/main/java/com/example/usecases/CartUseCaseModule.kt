package com.example.usecases

import com.example.domain.repositories.CartRepository
import com.example.domain.use_cases.cart.CalculateTaxUseCase
import com.example.domain.use_cases.cart.CalculateTotalPriceUseCase
import com.example.domain.use_cases.cart.ClearCartUseCase
import com.example.domain.use_cases.cart.DeleteCartItemUseCase
import com.example.domain.use_cases.cart.GetCartItemCountUseCase
import com.example.domain.use_cases.cart.GetCartItemsUseCase
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.cart.GetCartSubTotalUseCase
import com.example.domain.use_cases.cart.InsertCartItemUseCase
import com.example.domain.use_cases.cart.IsInCartItemUseCase
import com.example.domain.use_cases.cart.UpdateCartItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CartUseCaseModule {

    @Provides
    fun providesInsertItemUseCase(
        repository: CartRepository
    ): InsertCartItemUseCase = InsertCartItemUseCase(repository = repository)

    @Provides
    fun providesUpdateCartItemUseCase(
        repository: CartRepository
    ): UpdateCartItemUseCase = UpdateCartItemUseCase(repository = repository)

    @Provides
    fun providesGetCartItemsUseCase(
        repository: CartRepository
    ): GetCartItemsUseCase = GetCartItemsUseCase(repository = repository)

    @Provides
    fun providesGetCartSubTotalUseCase(
        repository: CartRepository
    ): GetCartSubTotalUseCase = GetCartSubTotalUseCase(repository = repository)

    @Provides
    fun providesGetCartTotalCountsUseCase(
        repository: CartRepository
    ): GetCartTotalCountsUseCase = GetCartTotalCountsUseCase(repository = repository)

    @Provides
    fun providesGetCartItemCountUseCase(
        repository: CartRepository
    ): GetCartItemCountUseCase = GetCartItemCountUseCase(repository = repository)

    @Provides
    fun providesIsInCartItemUseCase(
        repository: CartRepository
    ): IsInCartItemUseCase = IsInCartItemUseCase(repository = repository)

    @Provides
    fun providesDeleteCartItem(
        repository: CartRepository
    ): DeleteCartItemUseCase = DeleteCartItemUseCase(repository = repository)

    @Provides
    fun providesClearCartUseCase(
        repository: CartRepository
    ): ClearCartUseCase = ClearCartUseCase(repository = repository)

    @Provides
    fun providesCalculateTaxUseCase(): CalculateTaxUseCase = CalculateTaxUseCase()

    @Provides
    fun providesCalculateTotalPriceUseCase(): CalculateTotalPriceUseCase = CalculateTotalPriceUseCase()
}
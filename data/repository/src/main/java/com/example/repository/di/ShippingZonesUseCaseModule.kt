package com.example.repository.di

import com.example.domain.repositories.ShippingZonesRepository
import com.example.domain.use_cases.shipping_zones.GetShippingZonesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShippingZonesUseCaseModule {

    @[Provides Singleton]
    fun providesGetShippingZonesUseCase(
        repository: ShippingZonesRepository
    ): GetShippingZonesUseCase = GetShippingZonesUseCase(repository)
}
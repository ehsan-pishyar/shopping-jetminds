package com.example.usecases

import com.example.domain.repositories.CouponsRepository
import com.example.domain.use_cases.coupons.GetCouponDetailsUseCase
import com.example.domain.use_cases.coupons.GetCouponsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CouponsUseCaseModule {

    @Provides
    fun providesGetCouponsUseCase(
        repository: CouponsRepository
    ): GetCouponsUseCase = GetCouponsUseCase(repository)

    @Provides
    fun providesGetCouponsDetailsUseCase(
        repository: CouponsRepository
    ): GetCouponDetailsUseCase = GetCouponDetailsUseCase(repository)
}
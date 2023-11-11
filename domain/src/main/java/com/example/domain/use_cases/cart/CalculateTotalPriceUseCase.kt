package com.example.domain.use_cases.cart

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CalculateTotalPriceUseCase {
    operator fun invoke(subTotal: Int, tax: Int): Flow<Int?> = flow {
        if (subTotal == 0) {
            emit(0)
        } else {
            emit(subTotal + tax)
        }
    }
}
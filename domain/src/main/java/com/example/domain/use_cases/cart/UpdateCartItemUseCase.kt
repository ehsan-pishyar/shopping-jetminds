package com.example.domain.use_cases.cart

import com.example.domain.repositories.CartRepository

class UpdateCartItemUseCase constructor(
    private val repository: CartRepository
) {

    suspend operator fun invoke(
        productId: Int,
        inCart: Boolean,
        addedToCartDate: String
    ) {
        repository.updateInCartProduct(
            productId = productId,
            inCart = inCart,
            addedToCartDate = addedToCartDate
        )
    }
}
package com.example.core.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.models.ProductsResponse

class SharedViewModel: ViewModel() {

    var productState by mutableStateOf<ProductsResponse?>(null)
        private set

    fun addProduct(product: ProductsResponse) {
        productState = product
    }
}
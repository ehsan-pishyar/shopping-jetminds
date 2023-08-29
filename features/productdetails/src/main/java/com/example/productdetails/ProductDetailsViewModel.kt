package com.example.productdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.products.UpdateFavoriteProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val updateFavoriteProductUseCase: UpdateFavoriteProductUseCase
): ViewModel() {

    fun updateFavoriteProduct(productId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            updateFavoriteProductUseCase.invoke(productId = productId, isFavorite = isFavorite)
        }
    }
}
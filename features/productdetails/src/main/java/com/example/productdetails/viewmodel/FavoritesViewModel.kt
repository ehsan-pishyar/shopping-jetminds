package com.example.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.favorites.IsFavoriteProductUseCase
import com.example.domain.use_cases.favorites.UpdateFavoriteProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val updateFavoriteProductUseCase: UpdateFavoriteProductUseCase,
    private val isFavoriteProductUseCase: IsFavoriteProductUseCase
): ViewModel() {

    private var _isFavoriteState = MutableStateFlow(false)
    val isFavoriteState = _isFavoriteState.asStateFlow()

    fun updateFavoriteProduct(productId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            updateFavoriteProductUseCase.invoke(productId = productId, isFavorite = isFavorite)
        }
    }

    fun isFavoriteProduct(productId: Int) {
        viewModelScope.launch {
            isFavoriteProductUseCase.invoke(productId = productId).collect {
                if (it != null) {
                    _isFavoriteState.value = it
                }
            }
        }
    }
}
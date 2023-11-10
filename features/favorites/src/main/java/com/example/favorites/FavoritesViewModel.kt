package com.example.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.favorites.GetFavoriteProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteProductsUseCase: GetFavoriteProductsUseCase,
    private val getCartTotalCountsUseCase: GetCartTotalCountsUseCase
): ViewModel() {

    private var _state = MutableStateFlow(MainFavoritesUiState(emptyList()))
    val state = _state.asStateFlow()

    private val _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    init {
        getFavoriteProducts()
        getCartTotalCount()
    }

    private fun getFavoriteProducts() {
        viewModelScope.launch {
            getFavoriteProductsUseCase.invoke().collect { favorites ->
                _state.value = MainFavoritesUiState(
                    favorites = favorites
                )
            }
        }
    }

    private fun getCartTotalCount() {
        viewModelScope.launch {
            getCartTotalCountsUseCase.invoke().collect { size ->
                _cartTotalCountState.value = size!!
            }
        }
    }
}
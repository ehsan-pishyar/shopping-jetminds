package com.example.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.favorites.GetFavoriteProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteProductsUseCase: GetFavoriteProductsUseCase
): ViewModel() {

    private var _state = MutableStateFlow(MainFavoritesUiState(emptyList()))
    val state = _state.asStateFlow()

    init {
        getFavoriteProducts()
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
}
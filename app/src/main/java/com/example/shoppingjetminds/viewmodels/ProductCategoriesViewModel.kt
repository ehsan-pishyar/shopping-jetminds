package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.asResult
import com.example.domain.utils.Result

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val productCategoriesRepository: ProductCategoriesRepository
): ViewModel() {

    private var _state = mutableStateOf(CategoriesUiState())
    val state: State<CategoriesUiState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            productCategoriesRepository.getProductCategories().asResult().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _state.value = _state.value.copy(
                            loading = true
                        )
                    }
                    is Result.Success -> {
                        _state.value = _state.value.copy(
                            loading = false,
                            success = result.data
                        )
                    }
                    is Result.Error -> {
                        _state.value = _state.value.copy(
                            loading = false,
                            success = emptyList(),
                            error = result.throwable?.localizedMessage?.toString()!!
                        )
                    }
                }
            }
        }
    }
}

data class CategoriesUiState(
    val loading: Boolean = true,
    val success: List<ProductCategoriesResponse> = emptyList(),
    val error: String = ""
)
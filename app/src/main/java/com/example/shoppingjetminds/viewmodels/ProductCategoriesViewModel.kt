package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductTagsResponse
import com.example.domain.use_cases.product_tags.GetProductTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.ServiceResult

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val getProductTagsUseCase: GetProductTagsUseCase
): ViewModel() {

    private var _state = mutableStateOf(CategoriesUiState())
    val state: State<CategoriesUiState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
           getProductTagsUseCase.invoke().collect { categoriesResult ->
                when (categoriesResult) {
                    is ServiceResult.Loading -> {
                        _state.value = _state.value.copy(
                            loading = true
                        )
                    }
                    is ServiceResult.Success -> {
                        _state.value = _state.value.copy(
                            loading = false,
                            success = categoriesResult.data
                        )
                    }
                    is ServiceResult.Error -> {
                        _state.value = _state.value.copy(
                            loading = false,
                            success = emptyList(),
                            error = categoriesResult.throwable?.localizedMessage?.toString()!!
                        )
                    }
                }
            }
        }
    }
}

data class CategoriesUiState(
    val loading: Boolean = true,
    val success: List<ProductTagsResponse> = emptyList(),
    val error: String = ""
)
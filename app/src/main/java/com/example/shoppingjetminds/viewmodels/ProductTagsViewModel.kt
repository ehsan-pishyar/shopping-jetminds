package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductTagsResponse
import com.example.domain.use_cases.product_tags.GetProductTagDetailsUseCase
import com.example.domain.use_cases.product_tags.GetProductTagsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ProductTagsUiState {
    object Loading: ProductTagsUiState
    data class Success(val tags: List<ProductTagsResponse>): ProductTagsUiState
    data class Error(val message: String): ProductTagsUiState
}

sealed interface ProductTagDetailsUiState {
    object Loading: ProductTagDetailsUiState
    data class Success(val tagDetails: ProductTagsResponse): ProductTagDetailsUiState
    data class Error(val message: String): ProductTagDetailsUiState
}

data class MainProductTagsUiState(
    val tagsUiState: ProductTagsUiState
)

data class MainProductTagDetailsUiState(
    val tagDetailsUiState: ProductTagDetailsUiState
)

@HiltViewModel
class ProductTagsViewModel @Inject constructor(
    private val getProductTagsUseCase: GetProductTagsUseCase,
    private val getProductTagDetailsUseCase: GetProductTagDetailsUseCase
): ViewModel() {

    private var _tagsState = MutableStateFlow(MainProductTagsUiState(ProductTagsUiState.Loading))
    val tagsState = _tagsState.asStateFlow()

    private var _tagDetailsState = MutableStateFlow(MainProductTagDetailsUiState(ProductTagDetailsUiState.Loading))
    val tagDetailsState = _tagDetailsState.asStateFlow()

    init {

    }

    private fun getTags() {
        viewModelScope.launch {
            getProductTagsUseCase.invoke().collect { tagsResult ->
                val tagsUiStateResult = when (tagsResult) {
                    ServiceResult.Loading -> ProductTagsUiState.Loading
                    is ServiceResult.Success -> ProductTagsUiState.Success(
                        tags = tagsResult.data
                    )
                    is ServiceResult.Error -> ProductTagsUiState.Error(
                        message = tagsResult.throwable?.message!!
                    )
                }
                _tagsState.value = MainProductTagsUiState(tagsUiStateResult)
            }
        }
    }

    fun getTagDetails(tagId: Int) {
        viewModelScope.launch {
            getProductTagDetailsUseCase.invoke(tagId = tagId).collect { tagDetailsResult ->
                val tagDetailsUiStateResult = when (tagDetailsResult) {
                    ServiceResult.Loading -> ProductTagDetailsUiState.Loading
                    is ServiceResult.Success -> ProductTagDetailsUiState.Success(
                        tagDetails = tagDetailsResult.data
                    )
                    is ServiceResult.Error -> ProductTagDetailsUiState.Error(
                        message = tagDetailsResult.throwable?.message!!
                    )
                }
                _tagDetailsState.value = MainProductTagDetailsUiState(tagDetailsUiStateResult)
            }
        }
    }
}
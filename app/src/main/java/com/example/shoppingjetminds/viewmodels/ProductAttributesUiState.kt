package com.example.shoppingjetminds.viewmodels

import com.example.domain.models.ProductAttributesResponse

sealed interface ProductAttrsUiState {
    object Loading: ProductAttrsUiState
    data class Success(val attrs: List<ProductAttributesResponse>): ProductAttrsUiState
    data class Error(val message: String): ProductAttrsUiState
}

sealed interface ProductAttrDetailsUiState {
    object Loading: ProductAttrDetailsUiState
    data class Success(val attrDetails: ProductAttributesResponse): ProductAttrDetailsUiState
    data class Error(val message: String): ProductAttrDetailsUiState
}

data class MainProductAttrsUiState(
    val attrsUiState: ProductAttrsUiState
)

data class MainProductAttrDetailsUiState(
    val attrDetailsUiState: ProductAttrDetailsUiState
)
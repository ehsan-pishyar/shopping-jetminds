package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.product_shipping_classes.GetProductShippingClassesUseCase
import com.example.domain.utils.ServiceResult
import com.example.shoppingjetminds.uistates.MainProductShippingClassesUiState
import com.example.shoppingjetminds.uistates.ProductShippingClassesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductShippingClassesViewModel @Inject constructor(
    private val getProductShippingClassesUseCase: GetProductShippingClassesUseCase
): ViewModel() {

    private var _shippingClassesState = MutableStateFlow(MainProductShippingClassesUiState(
        ProductShippingClassesUiState.Loading
    )
    )
    val shippingClassesState = _shippingClassesState.asStateFlow()

    init {
        getShippingClasses()
    }

    private fun getShippingClasses() {
        viewModelScope.launch {
            getProductShippingClassesUseCase.invoke().collect { shippingClassesResult ->
                val shippingClassesUiStateResult = when (shippingClassesResult) {
                    ServiceResult.Loading -> ProductShippingClassesUiState.Loading
                    is ServiceResult.Success -> ProductShippingClassesUiState.Success(
                        shippingClasses = shippingClassesResult.data
                    )
                    is ServiceResult.Error -> ProductShippingClassesUiState.Error(
                        message = shippingClassesResult.throwable?.message!!
                    )
                }
                _shippingClassesState.value = MainProductShippingClassesUiState(
                    shippingClassesUiStateResult
                )
            }
        }
    }
}
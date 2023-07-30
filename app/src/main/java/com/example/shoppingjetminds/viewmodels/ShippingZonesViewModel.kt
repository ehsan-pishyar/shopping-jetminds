package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ShippingZonesResponse
import com.example.domain.use_cases.shipping_zones.GetShippingZonesUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ShippingZonesUiState {
    object Loading: ShippingZonesUiState
    data class Success(val shippingZones: List<ShippingZonesResponse>): ShippingZonesUiState
    data class Error(val message: String): ShippingZonesUiState
}

data class MainShippingZonesUiState(
    val shippingZonesUiState: ShippingZonesUiState
)

@HiltViewModel
class ShippingZonesViewModel @Inject constructor(
    private val getShippingZonesUseCase: GetShippingZonesUseCase
): ViewModel() {

    private var _shippingZonesState = MutableStateFlow(MainShippingZonesUiState(ShippingZonesUiState.Loading))
    val shippingZonesState = _shippingZonesState.asStateFlow()

    init {
        getShippingZones()
    }

    private fun getShippingZones() {
        viewModelScope.launch {
            getShippingZonesUseCase.invoke().collect { shippingZonesResult ->
                val shippingClassesUiStateResult = when (shippingZonesResult) {
                    ServiceResult.Loading -> ShippingZonesUiState.Loading
                    is ServiceResult.Success -> ShippingZonesUiState.Success(
                        shippingZones = shippingZonesResult.data
                    )
                    is ServiceResult.Error -> ShippingZonesUiState.Error(
                        message = shippingZonesResult.throwable?.message!!
                    )
                }
                _shippingZonesState.value = MainShippingZonesUiState(shippingClassesUiStateResult)
            }
        }
    }
}
package com.example.shoppingjetminds.viewmodels

import com.example.domain.use_cases.shipping_zones.GetShippingZonesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShippingZonesViewModel @Inject constructor(
    private val getShippingZonesUseCase: GetShippingZonesUseCase
) {
}
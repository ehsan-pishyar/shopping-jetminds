package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.product_shipping_classes.GetProductShippingClassesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductShippingClassesViewModel @Inject constructor(
    getProductShippingClassesUseCase: GetProductShippingClassesUseCase
): ViewModel() {
}
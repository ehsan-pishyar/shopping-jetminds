package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductAttributesViewModel @Inject constructor(
    private val getProductAttrsUseCase: GetProductAttrsUseCase,
    private val getProductAttrDetailsUseCase: GetProductAttrDetailsUseCase
): ViewModel() {
}
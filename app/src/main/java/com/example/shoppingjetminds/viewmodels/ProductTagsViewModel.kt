package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.product_tags.GetProductTagDetailsUseCase
import com.example.domain.use_cases.product_tags.GetProductTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductTagsViewModel @Inject constructor(
    private val getProductTagsUseCase: GetProductTagsUseCase,
    private val getProductTagDetailsUseCase: GetProductTagDetailsUseCase
): ViewModel() {
}
package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.products.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val getProductsByAttrIdUseCase: GetProductsByAttrIdUseCase,
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
    private val getProductsByTagIdUseCase: GetProductsByTagIdUseCase,
    private val getOnSaleProductsForHomeUseCase: GetOnSaleProductsForHomeUseCase,
    private val getPopularProductsForHomeUseCase: GetPopularProductsForHomeUseCase,
    private val getTopSalesProductsForHomeUseCase: GetTopSalesProductsForHomeUseCase,
    private val getNewestProductsForHomeUseCase: GetNewestProductsForHomeUseCase,
    private val getTopRatedProductsForHomeUseCase: GetTopRatedProductsForHomeUseCase
): ViewModel() {

    init {

    }
}
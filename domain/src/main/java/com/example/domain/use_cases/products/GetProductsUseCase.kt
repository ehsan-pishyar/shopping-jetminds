package com.example.domain.use_cases.products

import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class GetProductsUseCase constructor(
    private val repository: ProductsRepository
) {

//    operator fun invoke(): Flow<ServiceResult<List<ProductsResponse>>> =
//        repository.getProducts().asResult()

    operator fun invoke(categoryId: Int? = null): Flow<ServiceResult<List<ProductsResponse>>> =
        repository.getProducts().flatMapMerge {
            if (categoryId == null) {
                flowOf(it)
            } else {
                flow {
                    val filteredProducts = it.filter { product ->
                        product.categories?.any { category ->
                            category.id == categoryId
                        } == true
                    }
                    emit(filteredProducts)
                }
            }
        }.asResult()
}
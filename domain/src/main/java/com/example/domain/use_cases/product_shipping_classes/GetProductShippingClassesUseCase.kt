package com.example.domain.use_cases.product_shipping_classes

import com.example.domain.models.ProductShippingClassesResponse
import com.example.domain.repositories.ProductShippingClassesRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetProductShippingClassesUseCase constructor(
    private val productShippingClassesRepository: ProductShippingClassesRepository
){

    operator fun invoke(): Flow<ServiceResult<List<ProductShippingClassesResponse>>> =
        productShippingClassesRepository.getProductShippingClasses().asResult()
}
package com.example.repository.data_source.local

import com.example.cache.dao.ProductCategoriesDao
import javax.inject.Inject

class LocalProductCategoriesDataSource @Inject constructor(
    private val dao: ProductCategoriesDao
) {
}
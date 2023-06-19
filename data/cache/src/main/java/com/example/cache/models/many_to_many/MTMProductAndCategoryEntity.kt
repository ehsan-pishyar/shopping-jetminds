package com.example.cache.models.many_to_many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.cache.models.CategoryEntity
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.utils.CacheConstants

@Entity(
    tableName = CacheConstants.MTM_PRODUCT_CATEGORY_TABLE,
    primaryKeys = ["product_id", "category_id"],
    foreignKeys = [
        ForeignKey(entity = ProductsResponseEntity::class, parentColumns = ["id"], childColumns = ["product_id"]),
        ForeignKey(entity = CategoryEntity::class, parentColumns = ["id"], childColumns = ["category_id"])
    ]
)
data class MTMProductAndCategoryEntity(
    @ColumnInfo(name = "product_id")
    val productId: Int,
    @ColumnInfo(name = "category_id")
    val categoryId: Int
)
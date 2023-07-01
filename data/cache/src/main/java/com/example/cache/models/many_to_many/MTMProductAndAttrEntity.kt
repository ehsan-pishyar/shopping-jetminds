package com.example.cache.models.many_to_many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.cache.models.AttributeEntity
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.utils.CacheConstants

@Entity(
    tableName = CacheConstants.MTM_PRODUCT_ATTR_TABLE,
    primaryKeys = ["product_id", "attr_id"],
    foreignKeys = [
        ForeignKey(entity = ProductsResponseEntity::class, parentColumns = ["id"], childColumns = ["product_id"]),
        ForeignKey(entity = AttributeEntity::class, parentColumns = ["id"], childColumns = ["attr_id"]),
    ]
)
data class MTMProductAndAttrEntity(
    @ColumnInfo(name = "product_id")
    val productId: Int,
    @ColumnInfo(name = "attr_id")
    val attrId: Int
)
package com.example.cache.models.many_to_many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.cache.models.ProductsResponseEntity
import com.example.cache.models.TagEntity
import com.example.cache.utils.CacheConstants

@Entity(
    tableName = CacheConstants.MTM_PRODUCT_TAG_TABLE,
    primaryKeys = ["product_id", "tag_id"],
    foreignKeys = [
        ForeignKey(entity = ProductsResponseEntity::class, parentColumns = ["id"], childColumns = ["product_id"]),
        ForeignKey(entity = TagEntity::class, parentColumns = ["id"], childColumns = ["tag_id"])
    ]
)
data class MTMProductAndTagEntity(
    @ColumnInfo(name = "product_id")
    val productId: Int,
    @ColumnInfo(name = "tag_id")
    val tagId: Int
)

package com.example.network.models.wordpress

import com.google.gson.annotations.SerializedName

data class AvatarUrlsDto(
    @SerializedName("24")
    val size24: String?,
    @SerializedName("48")
    val size48: String?,
    @SerializedName("96")
    val size96: String?
)

package com.example.wordpress_network.models

import com.google.gson.annotations.SerializedName

data class UserResponseDto(
    val id: Int,
    val name: String,
    val url: String,
    val description: String,
    val link: String,
    val slug: String,
    @SerializedName("avatar_urls")
    val avatarUrls: AvatarUrlsDto?,
    @SerializedName("is_super_admin")
    val isSuperAdmin: Boolean
)
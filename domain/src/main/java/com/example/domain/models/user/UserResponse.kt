package com.example.domain.models.user


data class UserResponse(
    val id: Int,
    val name: String,
    val url: String,
    val description: String,
    val link: String,
    val slug: String,
    val avatarUrls: AvatarUrls?,
    val isSuperAdmin: Boolean
)
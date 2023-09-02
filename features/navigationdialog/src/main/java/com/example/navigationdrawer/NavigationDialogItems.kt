package com.example.navigationdrawer

data class NavigationDialogItem(
    val icon: Int,
    val title: String,
    val badge: Int,
    val onClick: () -> Unit
)

data class NavigationDialogBottomItem(
    val icon: Int,
    val title: String,
    val onClick: () -> Unit
)
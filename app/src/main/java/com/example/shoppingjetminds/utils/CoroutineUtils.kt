package com.example.shoppingjetminds.utils

import kotlinx.coroutines.flow.SharingStarted

private const val STOP_TIMEOUT_MILLIS = 5_000L

val WhileUiSubscribed: SharingStarted = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS)
package com.example.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary
)

@Composable
fun ShoppingJetMindsTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        // Using to hide status and navigation bar
        val systemUiController: SystemUiController = rememberSystemUiController()

        systemUiController.isStatusBarVisible = true // Status bar
        systemUiController.setStatusBarColor(Primary)

        val colors = LightColorScheme

        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            content = content
        )
    }
}
package com.example.shoppingjetminds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import com.example.shoppingjetminds.navigation.AppNavigation
import com.example.shoppingjetminds.ui.theme.ShoppingJetMindsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingJetMindsTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
                    // A surface container using the 'background' color from the theme
                    val navController = rememberNavController()
                    Surface {
                        AppNavigation(navHostController = navController)
                    }
                }
            }
        }
    }
}
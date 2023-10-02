package com.example.designsystem

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val Yekanbakh = FontFamily(
    Font(R.font.yekanbakh_light, FontWeight.Light),
    Font(R.font.yekanbakh_regular, FontWeight.Normal),
    Font(R.font.yekanbakh_semibold, FontWeight.SemiBold),
    Font(R.font.yekanbakh_bold, FontWeight.Bold)
)
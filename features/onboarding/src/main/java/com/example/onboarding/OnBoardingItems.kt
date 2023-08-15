package com.example.onboarding

import androidx.annotation.DrawableRes
import com.example.designsystem.R

sealed class OnBoardingItems(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingItems(
        image = R.drawable.android_image,
        title = "سورس کد اندروید",
        description = "سورس کدها، کامپوننت ها و اپ های سفارشی اندروید با بروزترین تکنولوژی گوگل"
    )

    object Second: OnBoardingItems(
        image = R.drawable.ui8_image,
        title = "رابط کاربری اپلیکیشن",
        description = "رابط های کاربری حرفه ای جمع آوری شده از مطرح ترین وب سایت های روز مانند UI8 و ..."
    )

    object Third: OnBoardingItems(
        image = R.drawable.illustrations_and_icons_3d,
        title = "دنیای سه بعدی",
        description = "دنیایی از آیکون ها و طرح های سه بعدی گردآوری شده برای اپلیکیشن های سفارشی شما"
    )
}
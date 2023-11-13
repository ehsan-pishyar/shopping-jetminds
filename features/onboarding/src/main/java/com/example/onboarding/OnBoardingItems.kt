/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/15/23, 6:49 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
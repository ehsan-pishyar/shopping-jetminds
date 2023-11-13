/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/29/23, 11:49 PM
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

package com.example.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.BlackColor
import com.example.designsystem.Primary
import com.example.designsystem.R

@Composable
fun JetIconText(
    toShopScreen: () -> Unit
) {
    Button(
        modifier = Modifier.width(80.dp).height(25.dp),
        onClick = { toShopScreen() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(2.dp)
    ) {
        JetText(
            text = "مشاهده همه",
            fontSize = 10,
            color = BlackColor
        )

        Spacer(modifier = Modifier.width(2.dp))

        Icon(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.play),
            contentDescription = null,
            tint = Primary
        )
    }
}

@Composable
@Preview
fun Preview_JetIconText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetIconText {}
    }
}
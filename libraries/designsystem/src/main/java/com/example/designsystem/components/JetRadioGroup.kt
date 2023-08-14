package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.R

@Composable
fun JetRadioGroup(items: List<String>) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(items[0]) }

    Column(modifier = Modifier
        .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items.forEach { title ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .clickable { onOptionSelected(title) },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.wallet),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(6f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        JetText(
                            text = title,
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RadioButton(
                            selected = (title == selectedOption),
                            onClick = { onOptionSelected(title) },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Primary,
                                unselectedColor = LighterGray
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_JetRadioGroup() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetRadioGroup(items = listOf("زرین پال", "پی پال", "ارسال رایگان"))
    }
}
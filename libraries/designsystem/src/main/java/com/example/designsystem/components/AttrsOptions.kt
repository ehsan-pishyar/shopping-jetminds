package com.example.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary

@Composable
fun AttrsOptions(options: List<String>) {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        userScrollEnabled = true
    ) {
        items(count = options.size) { position ->
            OptionsItem(item = options[position])
        }
    }
}

@Composable
fun OptionsItem(item: String) {
    Card(modifier = Modifier
        .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Primary.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = item,
                fontSize = 11
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview_OptionsItem() {
    OptionsItem(item = "احسان")
}

@Preview(showBackground = true)
@Composable
private fun Preview_AttrsOptions() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        AttrsOptions(options = listOf("احسان", "فاطمه", "قلبک", "احسانک"))
    }
}
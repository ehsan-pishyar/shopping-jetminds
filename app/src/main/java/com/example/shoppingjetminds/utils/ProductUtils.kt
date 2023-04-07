package com.example.shoppingjetminds.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime

// Takes beginning and ending date times and converts to separate integers(days, hours, minutes, seconds)
@RequiresApi(Build.VERSION_CODES.O)
fun onSaleCountDown(beginningDateTime: LocalDateTime, finishingDateTime: LocalDateTime): List<Int> {
    val duration: Duration = Duration.between(beginningDateTime, finishingDateTime)
    val seconds = duration.seconds
    val days = (seconds / 86400).toInt()
    val hours = ((seconds % 86400) / 3600).toInt()
    val minutes = ((seconds % 3600) / 60).toInt()
    val remainingSeconds = (seconds % 60).toInt()

    return listOf(days, hours, minutes, remainingSeconds)
}

// Takes price and add thousand separator to that price(12000 -> 12,000)
fun priceThousandsSeparator(price: String): String {
    val regex = "(\\d)(?=(\\d{3})+\$)".toRegex()
    return price.replace(regex, "$1,")
}
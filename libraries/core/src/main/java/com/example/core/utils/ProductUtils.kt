package com.example.core.utils

import android.os.Build
import android.text.Html
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Takes beginning and ending date times and converts to separate integers(days, hours, minutes, seconds)
@RequiresApi(Build.VERSION_CODES.O)
fun onSaleCountDown(beginningDateTime: String?, finishingDateTime: String?): List<Int> {

    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    val beginningTime = LocalDateTime.parse(beginningDateTime, formatter)
    val finishingTime = LocalDateTime.parse(finishingDateTime, formatter)

    val duration: Duration = Duration.between(beginningTime, finishingTime)
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

// Returns just 7 items if product list items are more than 7 else returns product items size
fun carouselProductsSize(size: Int): Int =
    if (size >= 7) 7 else size

fun parseHtml(html: String): String = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString()
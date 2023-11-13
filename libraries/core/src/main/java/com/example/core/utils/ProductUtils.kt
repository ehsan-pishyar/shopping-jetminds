/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/25/23, 10:37 PM
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

package com.example.core.utils

import android.os.Build
import android.text.Html
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

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

// Returns just 10 items if product list items are more than 10 else returns product items size
fun shopProductsSize(maxSize: Int): Int =
    if (maxSize >= 20) 20 else maxSize

fun parseHtml(html: String): String = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString()

fun calculateTax(totalAmount: String): String {
    return if (totalAmount.toInt() == 0) {
        "رایگان"
    } else {
        val tax = "${(totalAmount.toInt() * 0.09)}"
        priceThousandsSeparator(tax)
    }
}

fun calculatePayablePrice(totalAmount: String, tax: String): String {
    val payableAmount = "${(totalAmount.toInt() + tax.toInt())}"
    return priceThousandsSeparator(payableAmount)
}

fun getCurrentDate(): String {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(calendar.time)
}
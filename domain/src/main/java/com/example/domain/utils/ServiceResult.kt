/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/1/23, 8:45 PM
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

package com.example.domain.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L

//sealed class ServiceResult<T>(val data: T? = null, val error: String? = null) {
//    class Loading<T>(isLoading: Boolean = true): ServiceResult<T>()
//    class Success<T>(data: T? = null): ServiceResult<T>(data = data)
//    class Error<T>(data: T? = null, error: String? = null): ServiceResult<T>(data = data, error = error)
//}

sealed interface ServiceResult<out T> {
    data class Success<T>(val data: T): ServiceResult<T>
    data class Error(val throwable: Throwable? = null): ServiceResult<Nothing>
    object Loading: ServiceResult<Nothing>
}


/**
 * عملکرد این تابع به این صورته که یه extention function به اسم asResult و از نوع Flow هستش. یعنی توابعی که خروجیشون Flow هستش،
 * این تابع رو بهش اضافه میکنیم، تا اون تابع رو به وسیله کلاس Result به سه قسمت تقسیم کنه. یعنی ببینه که خروجی این تابع موفق بود یا خطا میده یا
 * در حال بارگذاریه.
 * اگه خروجیش موفق بود که چون یه خروجی به صورت T بهمون میده که یعنی معلوم نیس چیه، اونو با استفاده از تابع map به Result
 * و data class Success پاس میدیم. چون خروجی این تابع ما به صورت Flow هستش پس میتونیم از توابع Flow هم استفاده کنیم.
 * یعنی موقع شروع صدا زدن تابع، چی واسه ما برگردونه که این کار رو با تابع onStart که یکی از توابع Flow هستش انجام میدیم.
 * یکی دیگه از توابع مفید Flow تابع retryWhen هستش که موقع خطا توی برگردوندن دیتا استفاده میشه.
 * تابع Flow دیگه که توی این تابع مورد استفاده هستش، catch هستش که خطای برگردوندن تابع رو بهمون نشون میده.
 */

/**
 * مزیت این تابع چیه؟
 * اصلی ترین مزیتش اینه که چون ما باید کد Result رو توی همه repository ها مون تکرار میکردیم، با این تابع فقط کافیه که asResult رو به آخر
 * توابع repository هامون اضافه کنیم و تمام. دیگه از کدهای تکراری خبری نیست.
 */
fun <T> Flow<T>.asResult(): Flow<ServiceResult<T>> {
    return this
        .map<T, ServiceResult<T>> {
            ServiceResult.Success(it)
        }
        .onStart { emit(ServiceResult.Loading) }
        .retryWhen { cause, _ ->
            if (cause is IOException) {
                emit(ServiceResult.Error(cause))
                delay(RETRY_TIME_IN_MILLIS)
                true
            } else {
                false
            }
        }
        .catch { ServiceResult.Error(it) }
}



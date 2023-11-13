/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/1/23, 12:04 PM
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

package com.example.navigation

sealed class StartScreens(val route: String) {
    object Splash: StartScreens(route = "splash")
    object OnBoarding: StartScreens(route = "on_boarding")
}

sealed class AuthScreens(val route: String) {
    object Login: AuthScreens(route = "login")
    object Account: AuthScreens(route = "account")
}

sealed class DetailScreens(val route: String) {
    object ProductDetails : DetailScreens(route = "product_details")
    object UserInformation : DetailScreens(route = "user_information")
}
sealed class PaymentScreens(val route: String) {
    object Cart: PaymentScreens(route = "cart")
    object Checkout: PaymentScreens(route = "checkout")
    object Billing: PaymentScreens(route = "billing")
    object Orders: PaymentScreens(route = "orders")
    object Coupons: PaymentScreens(route = "coupons")
}

sealed class OtherScreens(val route: String) {
    object Favorite: OtherScreens(route = "favorites")
    object Compare: OtherScreens(route = "compare")
    object Search: OtherScreens(route = "search")
    object Address: OtherScreens(route = "address")
    object Downloads: OtherScreens(route = "downloads")
    object Notifications: OtherScreens(route = "notifications")
    object Settings: OtherScreens(route = "settings")
    object AboutUs: OtherScreens(route = "about_us")
}

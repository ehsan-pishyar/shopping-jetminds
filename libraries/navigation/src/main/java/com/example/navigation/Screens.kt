package com.example.navigation

sealed class StartScreens(val route: String) {
    object Splash: StartScreens(route = "splash")
    object OnBoarding: StartScreens(route = "on_boarding")
}

sealed class AuthScreens(val route: String) {
    object Login: AuthScreens(route = "login")
    object Verification: AuthScreens(route = "verification")
    object Account: AuthScreens(route = "account")
}

sealed class DetailScreens(val route: String) {
    object ProductDetails: DetailScreens(route = "product_details")
    object UserInformation: DetailScreens(route = "user_information")
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

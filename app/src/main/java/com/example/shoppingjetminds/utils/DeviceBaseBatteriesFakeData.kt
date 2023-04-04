package com.example.shoppingjetminds.utils

import com.example.shoppingjetminds.R

object DeviceBaseBatteriesFakeData {
    
    val devices = listOf(
        FakeDeviceBaseBatteries(title = "باتری دوربین", image = R.drawable.tag_camera),
        FakeDeviceBaseBatteries(title = "باتری ساعت", image = R.drawable.tag_clock),
        FakeDeviceBaseBatteries(title = "باتری چراغ قوه", image = R.drawable.tag_flashlight),
        FakeDeviceBaseBatteries(title = "باتری ریموت", image = R.drawable.tag_control),
        FakeDeviceBaseBatteries(title = "باتری اسباب بازی", image = R.drawable.tag_toy),
        FakeDeviceBaseBatteries(title = "باتری تلفن", image = R.drawable.tag_phone),
        FakeDeviceBaseBatteries(title = "باتری لوازم پزشکی", image = R.drawable.tag_medical),
        FakeDeviceBaseBatteries(title = "باتری ترازو", image = R.drawable.tag_scales)
    )
}

data class FakeDeviceBaseBatteries(
    val title: String,
    val image: Int
)



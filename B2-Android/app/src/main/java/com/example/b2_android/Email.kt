package com.example.b2_android

import androidx.annotation.ColorRes

data class Email(
    val sender: String,
    val subject: String,
    val snippet: String,
    val time: String,
    val initial: String,
    @ColorRes val colorRes: Int
)

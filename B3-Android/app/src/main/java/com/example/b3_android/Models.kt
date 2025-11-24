package com.example.b3_android

data class AppInfo(
    val name: String,
    val category: String,
    val rating: String,
    val size: String
)

data class Category(
    val title: String,
    val subtitle: String,
    val orientation: Int,
    val showArrow: Boolean,
    val apps: List<AppInfo>
)
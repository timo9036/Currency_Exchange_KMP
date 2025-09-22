package com.example.currency_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
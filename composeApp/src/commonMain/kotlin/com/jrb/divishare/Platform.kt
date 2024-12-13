package com.jrb.divishare

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
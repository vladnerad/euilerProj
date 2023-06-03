package com.company.seventhten

import com.company.EulerTask
import kotlin.math.sqrt

fun phi(number: Int): Int {
    var n = number
    var result = number
    for (i in 2..sqrt(number.toDouble()).toInt() + 1) {
        if (n % i == 0) {
            while (n % i == 0) n /= i
            result -= result / i
        }
    }
    if (n > 1) result -= result / n
    return result
}

class Task69 : EulerTask {
    override fun getAnswer(): Int {
        var result = 0
        var maxRatio = 0.0
        for (i in 1000000 downTo 2) {
            val ratio = i.toDouble() / phi(i)
            if (ratio > maxRatio) {
                maxRatio = ratio
                result = i
            }
        }
        return result
    }
}

fun main() {
    println(phi(2))
    println(phi(6))
    println(phi(9))
    println(phi(63))
    println(phi(99))
}
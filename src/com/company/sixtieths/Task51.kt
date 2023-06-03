package com.company.sixtieths

import kotlin.math.sqrt

fun getAnswer(): Int {
    for (i in 56997..Int.MAX_VALUE step 2)
        i.toChar()
    return 777
}

fun isPrime(number: Int): Boolean {
    if (number % 2 == 0) return number == 2
    if (number == 1) return false
    for (i in 3..sqrt(number.toDouble()).toInt() + 1 step 2) {
        if (number % i == 0) return false
    }
    return true
}

fun main() {
    println(isPrime(21))
    println(isPrime(23))
}
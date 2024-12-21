package ru.morozovit.util

import kotlin.math.pow
import kotlin.math.round

inline fun <R> runOrNull(block: () -> R): R? =
    try {
        block()
    } catch (e: Throwable) {
        null
    }

inline fun <T, R> T.runOrNull(block: T.() -> R): R? =
    try {
        block(this)
    } catch (e: Throwable) {
        null
    }

inline fun <R> runOr(value: R, block: () -> R): R =
    try {
        block()
    } catch (e: Throwable) {
        value
    }

inline fun <T, R> T.runOr(value: R, block: T.() -> R): R =
    try {
        block(this)
    } catch (e: Throwable) {
        value
    }

inline fun <T> apply(vararg types: T, block: T.() -> Unit) {
    types.forEach(block)
}

val Number.f get() = toFloat()

val Float.points: Int get() {
    var counter = 0
    for (char in toString().reversed()) {
        if (char != ',') counter++ else break
    }
    return counter
}

fun Float.shrinkBy(points: Int) = shrinkTo(this.points - points)

fun Float.shrinkTo(points: Int): Float {
    val pow = 10f.pow(points)
    return round(this * pow) / pow
}

fun Float.strip() = shrinkTo(0)
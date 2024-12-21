package ru.morozovit.progresscounter

import kotlinx.browser.document
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSpanElement
import ru.morozovit.util.apply
import ru.morozovit.util.f
import ru.morozovit.util.js.addEventListener
import ru.morozovit.util.runOr
import ru.morozovit.util.shrinkTo

fun main() {
    val wholeCount = document.getElementById("wholeCount") as HTMLInputElement
    val completedCount = document.getElementById("completedCount") as HTMLInputElement
    val progressActive = document.getElementById("progress_active") as HTMLDivElement
    val progressCount = document.getElementById("progress_count") as HTMLSpanElement
    apply(wholeCount, completedCount) {
        addEventListener("input") {
            if (wholeCount.value != "") {
                val whole = wholeCount.value.toInt()
                val completed = runOr(0) {
                    completedCount.value.toInt()
                }

                val completedPercent = runOr(0f) { completed.f / whole.f * 100f }
                progressActive.style.width = "$completedPercent%"
                val shrinkedPercent = completedPercent.shrinkTo(1)
                println(shrinkedPercent)
                progressCount.textContent = "$shrinkedPercent%"
            }
        }
    }
}

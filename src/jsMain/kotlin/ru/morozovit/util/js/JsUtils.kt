package ru.morozovit.util.js

import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event

inline fun HTMLElement.addEventListener(type: String, noinline listener: (Event) -> Unit) {
    addEventListener(type, listener)
}
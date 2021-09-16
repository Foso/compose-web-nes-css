package de.jensklingenberg.composewebnes

import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.HTMLTableElement

fun AttrsBuilder<HTMLTableElement>.nesTable(isDark: Boolean = false, isBordered: Boolean = false, isCentered: Boolean = false) {
    val isBorderedText = if (isBordered) {
        "is-bordered"
    } else {
        ""
    }

    val isCenteredText = if (isCentered) {
        "is-centered"
    } else {
        ""
    }

    val tt = "nes-table $isBorderedText $isCenteredText ${getDarkStringIfTrueOrNull(isDark)}"
    tt.split(" ").forEach {
        if(it.isNotEmpty()){
            classes(it)
        }
    }
}
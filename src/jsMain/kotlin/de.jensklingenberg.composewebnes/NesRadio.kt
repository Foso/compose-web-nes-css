package de.jensklingenberg.composewebnes

import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.HTMLInputElement

fun AttrsBuilder<HTMLInputElement>.nesRadio(isDark: Boolean = false) {
    myclassProp("nes-radio")
    getDarkStringIfTrueOrNull(isDark)?.let {
        myclassProp(it)
    }
}
package de.jensklingenberg.composewebnes


import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.HTMLDivElement

fun AttrsBuilder<HTMLDivElement>.nesField() {
    myclassProp("nes-field")
}
package de.jensklingenberg.composewebnes

import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.HTMLSpanElement


enum class NesTextType(val value: String) {
    SUCCESS("is-success"), WARNING("is-warning"), ERROR("is-error"), NORMAL(""),DISABLED("is-disabled")
}

fun AttrsBuilder<HTMLSpanElement>.nesText(nesTextType: NesTextType=NesTextType.NORMAL) {
    classes("nes-text")
    if(nesTextType.value.isNotEmpty()){
        classes(nesTextType.value)
    }
}

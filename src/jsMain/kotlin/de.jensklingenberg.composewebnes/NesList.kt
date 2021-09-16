package de.jensklingenberg.composewebnes


import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.w3c.dom.HTMLUListElement


enum class NesList(val value: String) {
    DISC("nes-list is-disc"),
    CIRCLE("nes-list is-circle")
}


fun AttrsBuilder<HTMLUListElement>.nesList(type: NesList) {
    type.value.split(" ").forEach {
        if(it.isNotEmpty()){
            classes(it)
        }
    }
}
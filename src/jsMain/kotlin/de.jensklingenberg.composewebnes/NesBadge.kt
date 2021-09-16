package de.jensklingenberg.composewebnes

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLAnchorElement

fun AttrsBuilder<HTMLAnchorElement>.nesBadge(isSplited: Boolean = false, isIcon: Boolean = false) {
    val splited = if (isSplited) {
        "is-splited"
    } else {
        ""
    }

    val isIconText = if (isIcon) {
        "is-icon"
    } else {
        ""
    }
    classes("nes-badge")

    if(splited.isNotEmpty()){
        classes(splited)
    }
    if(isIconText.isNotEmpty()){
        classes(isIconText)
    }

}


@Composable
fun NesBadge() {
    A(attrs = {
        nesBadge(isIcon = true)
    }) {
        Span(attrs = {
            classes("is-dark")
        }) {
            Text("hi")
        }
        Span(attrs = {
            classes("is-warning")
        }) {
            Text("test")
        }
    }
}
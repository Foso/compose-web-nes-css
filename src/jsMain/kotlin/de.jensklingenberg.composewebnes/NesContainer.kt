package de.jensklingenberg.composewebnes

import androidx.compose.runtime.Composable

import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

data class NesContainerStyle(
    val isCentered: Boolean = false,
    val isRounded: Boolean = false,
    val isDark: Boolean = false
) {
    override fun toString(): String {
        val alignment = if (isCentered) {
            "is-centered"
        } else {
            ""
        }

        val rounded = if (isRounded) {
            "is-rounded"
        } else {
            ""
        }
        return "with-title $alignment $rounded ${getDarkStringIfTrueOrNull(isDark)}"
    }
}


fun AttrsBuilder<HTMLDivElement>.nesContainer(style: NesContainerStyle = NesContainerStyle()) {
    classes("nes-container")
    classes("with-title")
   // classes("$style")
    style.toString().split(" ").forEach {
        if(it.isNotEmpty()){
            classes(it)
        }
    }
}

@Composable
fun NesContainer(
    title: @Composable ()->Unit={},
    style: NesContainerStyle = NesContainerStyle(),
    content: @Composable () -> Unit
) {
    Div(attrs = {
        nesContainer(style)
    }) {
        Span(attrs = {
            classes("title")
        }) {
           title()
        }

        content()

    }
}

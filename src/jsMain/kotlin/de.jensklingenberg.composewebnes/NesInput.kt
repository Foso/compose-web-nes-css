package de.jensklingenberg.composewebnes

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLInputElement


enum class NesInputType(val value: String) {
    SUCCESS("is-success"), WARNING("is-warning"), ERROR("is-error"), NORMAL(""),DARK("is-dark")
}


fun AttrsBuilder<HTMLInputElement>.nesInput(type: NesInputType = NesInputType.NORMAL) {
    classes("nes-input")
    if (type.value.isNotEmpty()) {
        classes(type.value)
    }
}

@Composable
fun NesInput(lableText: String = "", type: NesInputType = NesInputType.NORMAL) {
    Div(attrs = {
        nesField()
    }) {
        Label(attrs = {
            attr("for", "name_field")
        }) {
            Span {
                Text(lableText)
            }
        }

        Input(
            type = InputType.Text,
            attrs = {
                nesInput(type)
                id("name_field")
            }
        )
    }
}
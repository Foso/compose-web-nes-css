package de.jensklingenberg.composewebnes


import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.InputType

import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.w3c.dom.HTMLInputElement

fun AttrsBuilder<HTMLInputElement>.nesCheckbox(isDark: Boolean = false) {
    myclassProp("nes-checkbox $${getDarkStringIfTrueOrNull(isDark)}")
}

@Composable
fun NesCheckbox(checked: Boolean,onClick:()->Unit,content: @Composable ()->Unit) {

    Label {
        Input(
            type = InputType.Checkbox,
            attrs = {
                nesCheckbox()
                checked(checked)
                onChange {
                    onClick()
                }

            }
        )

        content()
    }
}
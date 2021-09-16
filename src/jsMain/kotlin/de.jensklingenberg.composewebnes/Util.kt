package de.jensklingenberg.composewebnes

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.CSSpxValue
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.Element

fun AttrsBuilder<*>.myclassProp(value: String) {

       this.classes(value)
}

fun getDarkStringIfTrueOrNull(isDark: Boolean): String? {
    return if (isDark) {
        "is-dark"
    } else {
       null
    }
}


@Composable
fun HeightSpacer(height: CSSpxValue) {
    Div(attrs = { style { padding(height) } })
}
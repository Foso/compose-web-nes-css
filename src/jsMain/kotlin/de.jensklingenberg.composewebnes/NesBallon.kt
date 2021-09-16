package de.jensklingenberg.composewebnes

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

data class NesBallonStyle(val isDark: Boolean = false) {
    override fun toString(): String {
        return getDarkStringIfTrueOrNull(isDark)?:""
    }
}

enum class Direction(val value: String) {
    FROM_LEFT("from-left"), FROM_RIGHT("from-right")
}

fun AttrsBuilder<HTMLDivElement>.nesBalloon(type: Direction, style: NesBallonStyle = NesBallonStyle()) {
    val directionString = type.value
    "nes-balloon $directionString $style".split(" ").filter { it.isNotEmpty() }.forEach {
        myclassProp(it)
    }

}

@Composable
fun NesBalloon(
    type: Direction = Direction.FROM_LEFT,
    style: NesBallonStyle = NesBallonStyle(),
    content: @Composable () -> Unit
) {
    Div(attrs = {
        nesBalloon(type,style)
    }) {
        content()
    }
}
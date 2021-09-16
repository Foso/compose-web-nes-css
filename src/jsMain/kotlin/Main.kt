@file:OptIn(ExperimentalComposeWebWidgetsApi::class)

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import de.jensklingenberg.composewebnes.Direction
import de.jensklingenberg.composewebnes.HeightSpacer
import de.jensklingenberg.composewebnes.NesBadge
import de.jensklingenberg.composewebnes.NesBalloon
import de.jensklingenberg.composewebnes.NesButtonType
import de.jensklingenberg.composewebnes.NesCheckbox
import de.jensklingenberg.composewebnes.NesContainer
import de.jensklingenberg.composewebnes.NesContainerStyle
import de.jensklingenberg.composewebnes.NesInput
import de.jensklingenberg.composewebnes.NesInputType
import de.jensklingenberg.composewebnes.NesList
import de.jensklingenberg.composewebnes.NesProgress
import de.jensklingenberg.composewebnes.NesProgressType
import de.jensklingenberg.composewebnes.NesTextType
import de.jensklingenberg.composewebnes.nesButton
import de.jensklingenberg.composewebnes.nesList
import de.jensklingenberg.composewebnes.nesRadio
import de.jensklingenberg.composewebnes.nesTable
import de.jensklingenberg.composewebnes.nesText
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.ui.ExperimentalComposeWebWidgetsApi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.Tbody
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Th
import org.jetbrains.compose.web.dom.Thead
import org.jetbrains.compose.web.dom.Tr
import org.jetbrains.compose.web.dom.Ul
import org.jetbrains.compose.web.renderComposable


fun main() {
    val count = mutableStateOf(0)


    renderComposable(rootElementId = "root") {
        val checked by remember { mutableStateOf(false) }

        Div(attrs = { style { padding(50.px) } }) {
            Text("Hello World")

            Column {
                TextDemo()


                ContainerDemo()
                BadgeDemo()
                HeightSpacer(50.px)
                ListDemo()

                ButtonsDemo()
                ProgressDemo()
                TableDemo()
                BallonDemo()
                RadioButtonDemo()
                InputDemo()
            }

        }
    }
}

@Composable fun TextDemo() {
    NesContainer(title = { H3 { Text("Texts") } }) {
        NesTextType.values().forEach {
            Span(attrs = {
                nesText(it)
            }) {
                Text(it.name)
            }
        }
    }
}


@Composable
fun InputDemo() {
    NesContainer(title = { Text("Inputs") }) {
        NesInputType.values().forEach {
            NesInput(it.name, it)
        }
    }
}


@Composable
fun BadgeDemo() {
    NesBadge()
}


@OptIn(ExperimentalComposeWebWidgetsApi::class)
@Composable
fun ButtonsDemo() {
    Div {
        NesContainer(title = { Text("Buttons") }) {
            NesButtonType.values().forEach {


                Button(attrs = {
                    nesButton(it)
                }) {
                    Text(it.name)
                }

            }
        }
    }


}

@Composable
fun ProgressDemo() {

    NesProgressType.values().forEachIndexed { index, type ->
        Text(type.name)
        NesProgress(type, (index + 1) * 10, 100)
    }

}


@Composable
fun TableDemo() {
    NesContainer({ Text("Table") }) {
        listOf(false, true).forEach { isDark ->
            Table(attrs = {
                nesTable(isCentered = true, isBordered = true, isDark = isDark)
            }) {
                Thead {
                    Tr {
                        Th {
                            Text("Table.is-bordered")
                        }
                        Th {
                            Text("Table.is-centered")
                        }
                        Th {
                            Text("Table.is-centered")
                        }
                        Th {
                            Text("Table.is-centered")
                        }
                    }
                }
                Tbody {
                    Tr {
                        Td {
                            Text("Thou hast had a good morning")
                        }
                        Td {
                            Text("Thou hast had a good afternoon")
                        }
                        Td {
                            Text("Thou hast had a good evening")
                        }
                        Td {
                            Text("Thou hast had a good night")
                        }
                    }

                    Tr {
                        Td {
                            Text("Thou hast had a good morning")
                        }
                        Td {
                            Text("Thou hast had a good afternoon")
                        }
                        Td {
                            Text("Thou hast had a good evening")
                        }
                        Td {
                            Text("Thou hast had a good night")
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun CheckboxDemo(checked: Boolean) {
    var checked1 = checked
    NesCheckbox(checked1, onClick = {
        checked1 = !checked1
    }) {
        Span {
            Text("Hanhh")
        }
    }
}


@OptIn(ExperimentalComposeWebWidgetsApi::class)
@Composable
private fun RadioButtonDemo() {


    Div {


        Label(attrs = {
            style { }
        }) {
            Input(
                type = InputType.Radio,
                attrs = {
                    name("answer")
                    nesRadio()
                }
            )
            //
            Span {
                Text("Yes")
            }
        }

        Label(attrs = {
            style {

            }
        }) {
            Input(
                type = InputType.Radio,
                attrs = {
                    name("answer")
                    nesRadio()
                }
            )
            //
            Span {
                Text("No")
            }
        }

    }
    Div {


        Label(attrs = {
            style { }
        }) {
            Input(
                type = InputType.Radio,
                attrs = {
                    name("answer-dark")
                    nesRadio(true)
                }
            )
            //
            Span {
                Text("Yes")
            }
        }

        Label(attrs = {
            style {

            }
        }) {
            Input(
                type = InputType.Radio,
                attrs = {
                    name("answer-dark")
                    nesRadio(true)
                }
            )
            //
            Span {
                Text("No")
            }
        }

    }


}

@OptIn(ExperimentalComposeWebWidgetsApi::class)
@Composable
private fun BallonDemo() {
    Column {
        NesBalloon {
            Text("Good Morning")
        }
        NesBalloon(type = Direction.FROM_RIGHT) {
            Text("Good Night")
        }
    }
}

@Composable
fun ContainerDemo() {

    NesContainer({ Text("Containers") }) {
        NesContainer(title = {
            Text("Container.is-centered")
        }, NesContainerStyle(isCentered = true)) {
            Text("Good Morning")
        }

        NesContainer(title = {
            Text("Container.is-dark")
        }, NesContainerStyle(isDark = true)) {
            Text("Good Morning")
        }
        NesContainer(style = NesContainerStyle(isRounded = true)) {
            Text("Container is rounded")
        }

        NesContainer(style = NesContainerStyle(isRounded = true, isDark = true)) {
            Text("Container is rounded and dark")
        }
    }
}


@Composable
fun ListDemo() {
    val sampleText = listOf(
        "Good Morning",
        "Thou hast had a good night's sleep, I hope.",
        "Thou hast had a good afternoon",
        "Good Night"
    )

    NesContainer(title = { Text("Lists") }) {
        Column {
            Ul(attrs = {
                nesList(NesList.DISC)
            }) {
                sampleText.forEach {
                    Li() {
                        Text(it)
                    }
                }
            }

            Ul(attrs = {
                nesList(NesList.CIRCLE)

            }) {
                sampleText.forEach {
                    Li() {
                        Text(it)
                    }
                }
            }
        }
    }


}

package de.jensklingenberg.composewebnes


import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.w3c.dom.HTMLButtonElement


fun AttrsBuilder<HTMLButtonElement>.nesButton(type: NesButtonType) {
    //this.type(ButtonType.Button)
  //  myclassProp(type.value)
   type.value.split(" ").forEach {
       classes(it)
   }

}

enum class NesButtonType(val value: String) {
    NORMAL("nes-btn"),
    WARNING("nes-btn is-warning"),
    ERROR("nes-btn is-error"),
    SUCCESS("nes-btn is-success"),
    DISABLED("nes-btn is-disabled")
}
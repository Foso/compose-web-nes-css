package de.jensklingenberg.composewebnes

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.selectors.CSSSelector
import org.jetbrains.compose.web.dom.Progress
import org.w3c.dom.HTMLProgressElement


enum class NesProgressType(val value: String) {
    NORMAL(""),
    PRIMARY("is-primary"),
    SUCCESS("is-success"),
    WARNING("is-warning"),
    ERROR("is-error"),
    PATTERN("is-pattern"),
}


fun AttrsBuilder<HTMLProgressElement>.nesProgress(type: NesProgressType) {
    classes("nes-progress")
    if(type.value.isNotEmpty()){
        classes(type.value)

    }
}

@Composable
fun NesProgress(type:NesProgressType,value2:Int,maxValue2:Int) {

    Progress(attrs = {
        attr("value",value2.toString())
        attr("max",maxValue2.toString())
        nesProgress(type)
        style {



        }


    })


}
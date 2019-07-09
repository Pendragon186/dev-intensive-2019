package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*
import ru.skillbranch.devintensive.models.User

class TextMessage(
    id:String,
    from:User?,
    chat:Chat,
    isIncoming: Boolean = false,
    date:Date = Date(),
    var text:String?
): BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String = "id:$id, ${from?.firstName} ${if(isIncoming) "get" else "send"} message $text ${date.humanizeDiff()}"

}
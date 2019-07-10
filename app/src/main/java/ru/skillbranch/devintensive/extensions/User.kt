package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils


fun User.toUserView():UserView{
    val nickname = Utils.transliteration("$firstName $lastName", "_")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Не разу не был" else if (isOnline) "Пользаватель  онлайн" else "Последний визит был ${lastVisit.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickname,
        initials = initials,
        avatar = avatar,
        status = status
    )
}



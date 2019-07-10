package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (val id:String,
                 var firstName:String?,
                 var lastName:String?,
                 var avatar:String?,
                 var rating:Int = 0,
                 var respect:Int = 0,
                 val lastVisit:Date? = null,
                 val isOnline:Boolean = false)
{


    constructor(id:String, firstName:String?, lastName:String?): this(id, firstName, lastName, null)
    constructor(id: String): this(id, "Funny", "Love")

    init {

        println("wow, it`s magic!\n"+
                "${if (lastName==="Love") "Name of magician $firstName $lastName" else "Apparently his name $firstName $lastName Kappa"} \n")
    }

        companion object Factory{
            private var lastId: Int = -1
            fun makeUser(fullName:String?): User{
                lastId++

                var (firstName, lastName) = Utils.parseFullName(fullName)

                return User(id = "$lastId", firstName = firstName, lastName = lastName)
            }
        }

}
package ru.skillbranch.devintensive.extensions

fun String.stripHTML ():String{
    return this.replace("<.*?>".toRegex(),"").replace("\\s+".toRegex()," ")
}
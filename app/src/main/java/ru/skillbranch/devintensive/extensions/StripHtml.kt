package ru.skillbranch.devintensive.extensions

fun String.stripHtml ():String{
    return this.replace("<.*?>".toRegex(),"").replace("\\s+".toRegex()," ")
}
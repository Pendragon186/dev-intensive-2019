package ru.skillbranch.devintensive.extensions

 fun String.truncate(length:Int = 16) :String{
     val diff:Int

     return if( length <= this.length ) {
         diff = this.substring(0,length).length - this.substring(0,length).trim().length

         return when(diff){
             0 -> this.substring(0,length)+"..."
             else -> "${this.substring(0, length-diff)}..."
         }
     }
     else this.trim()
}
package ru.skillbranch.devintensive.extensions


import android.text.format.DateUtils
import android.util.TimeUtils
import java.util.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.concurrent.TimeUnit

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.MM.YYYY"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.add (vallue:Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time
   time += when (units){
        TimeUnits.SECOND -> vallue * SECOND
        TimeUnits.MINUTE -> vallue * MINUTE
        TimeUnits.HOUR -> vallue * HOUR
        TimeUnits.DAY -> vallue * DAY
        else -> throw IllegalStateException("Invalid unit!!!")
    }
    this.time = time
    return this
}
enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
fun Date.humanizeDiff(date: Date = Date()): String {
    var diff = (date.time - this.time)/1000
    var min = 0
    var hour = 0
    var day = 0


        if (diff in 0..1) {
            return "только что"
        }
        else if (diff in 2..45){
            return "несколько секунд назад"
        }

        min = (diff/60).toInt()

    if (diff in 45..75) return  " минуту назад"
    if (diff >= 76 && min < 45) {
            if (min == 1) return  "$min минуту назад"
            else if ( min in 2..4) return  "$min минуты назад"
            return  "$min минут назад"
        }
    if (min in 45..75) return  " час назад"
        hour = min/60
    if (min >= 76 && hour < 22){
        if ( hour in 2..4) return  "$hour часа назад"
        return  "$hour часов назад"
    }
    if (hour in 23..26) return  " день назад"
        day = hour/24
        if (hour >= 27 && day < 360) {
            if (day in 2..4) return  "$day дня назад"
            return  "$day дней назад"
        }

        else if (day >= 360 ) return "больше года назад"
        return "Invalid value"
}
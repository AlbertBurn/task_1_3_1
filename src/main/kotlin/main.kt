package ru.netology

fun main() {
    val numberOfSeconds = 10000
    println("был(а) " + agoToText(numberOfSeconds))

}

fun agoToText(
    numberOfSeconds: Int
): String {
    val text = when (numberOfSeconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> makeCasesOfMinutes(numberOfSeconds)
        in 60 * 60 + 1..24 * 60 * 60 -> makeCasesOfHours(numberOfSeconds)
        in 24 * 60 * 61..2 * 24 * 60 * 60 -> "вчера"
        in 2 * 24 * 60 * 61..3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
    return text
}

fun makeCasesOfMinutes(
    numberOfSeconds: Int
): String {
    val minutes = numberOfSeconds / 60
    var text = when (minutes) {
        1 -> " минуту"
        in 2..4 -> " минуты"
        else -> " минут"
    }
    if (minutes % 10 == 1) {
        text = " минуту"
    }
    return "$minutes $text назад"
}

fun makeCasesOfHours(
    numberOfSeconds: Int
): String {
    val hours = numberOfSeconds / (60 * 60)
    var text = when (hours) {
        1 -> " час"
        in 2..4 -> " часа"
        else -> " часов"
    }
    if (hours % 10 == 1) {
        text = " час"
    }
    return "$hours $text назад"
}
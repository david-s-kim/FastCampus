// range
for (value in 0..5) {
    println("반복")
}
// progression + step
for (value in 0..5 step (2)) { // 0 -> 2 -> 4
    println("반복 1")
}
// progression + downTo
for (value in 5 downTo 0) {
    println("반복 2")
}

// collection
val numbers = listOf<Int>(0, 1, 2, 3)
for (number in numbers) {
    println(number)
}
for (i in 0..numbers.size) { // 0..4
    println("반복 3")
}
for (i in 0 until numbers.size) { // 0..3
    println("반복 4")
}
for ((index, number) in numbers.withIndex()) {
    println("" + index + "  |  " + number)
}

// foreach
numbers.forEach{
    println(it)
}











// 1.
fun repeatText(repeatText: String, repeatNumber: Int) {
//    for (i in 0..repeatNumber - 1) println(repeatText)
    for (i in 1..repeatNumber) println(repeatText)
//    for (i in until repeatNumber) println(repeatText)
}
repeatText("안녕", 2)


// 2.
fun sumUntil(givenNumber: Int): Int {
    var sum: Int = 0
    for (i in 1..givenNumber) sum++
    return sum
    // 0부터 10 까지 값의 합
    // 0부터 10 까지 인덱스의 합
}
sumUntil(10)


// 3.
fun sum7s(): Int {
    var sum: Int = 0
    for (i in 0..100) {
        if (i % 7 == 0) sum += i
    }
    return sum
}
sum7s()


//4.
fun increaseOne(numberUnder100: Int) {
    var givenNumber: Int = numberUnder100 //파라미터는 value이기 때문에 var에 넣어준다.
    while (givenNumber < 100) {
        givenNumber++
        println("UP")
    }
    return
}
increaseOne(99)


//5.
fun checkPassOrNot(examScores: List<Int>): BooleanArray {
    val resultArray = BooleanArray(examScores.size, { false })
    examScores.forEachIndexed { index, score ->
        if (score >= 80) resultArray[index] = true
        else resultArray[index] = false

    }
    return resultArray
}

val result = checkPassOrNot(listOf<Int>(70, 71, 72, 77, 78, 79, 80, 82, 90, 99))
result.forEach {
    println(it)
}


//6.
fun findSumIsSixFromDice(): List<List<Int>> {
    val resultList = mutableListOf<List<Int>>()
    for (i in 1..6) {
        for (j in 1..6) {
            if (i + j == 6) {
                val temp = listOf<Int>(i, j)
                resultList.add(temp)
            }
        }
    }
    return resultList
}
println(findSumIsSixFromDice())


// 7.
fun eatUntilNotHungry(totalCount: Int, currentCount: Int) {
    var currentCountCopy: Int = currentCount
    do {
        println("밥을 먹었다.")
        currentCountCopy++
    } while (currentCountCopy < totalCount)
    println("배가 부르다.")
}
eatUntilNotHungry(10, 5)


// 8.
fun killNthArmy(
    firstArmy: List<String>,
    secondArmy: List<String>,
    killNth: Int
): List<List<String>>? {
    if (firstArmy.size < killNth || secondArmy.size < killNth) return null
    var firstArmyTemp = mutableListOf<String>()
    var secondArmyTemp = mutableListOf<String>()
    for ((index, army) in firstArmy.withIndex()) {
        if (index != killNth) firstArmyTemp.add(army)
    }
    for ((index, army) in secondArmy.withIndex()) {
        if (index != killNth) secondArmyTemp.add(army)
    }
    val result = listOf<List<String>>(firstArmyTemp, secondArmyTemp)
    return result
}

println(
    killNthArmy(
        firstArmy = listOf<String>("A", "B", "C", "D", "E"),
        secondArmy = listOf<String>("A", "B", "C"),
        killNth = 2
    )
)


// 9.
fun gugudan(dan: Int) {
    val numbers = mutablelistOf<Int>()
    for (i in 1..9) {
        numbers.add(dan * i)
    }
    println(numbers)
}
gugudan(8)


// 10.
fun splitNumbers(firstIntList: List<Int>, secondIntList: List<Int>): Map<String, List<Int>> {
    val result = mutableMapOf<String, List<Int>>()
    val totalIntList = mutableListOf<Int>()
    totalIntList.addAll(firstIntList)
    totalIntList.addAll(secondIntList)

    val evenNumber = mutableListOf<Int>()
    val oddNumber = mutableListOf<Int>()

    totalIntList.forEach { number ->
        if (number % 2 == 0) evenNumber.add(number)
        else oddNumber.add(number)
    }
    result.put("짝수", evenNumber)
    result.put("홀수", oddNumber)
    return result
}
println(
    splitNumbers(
        listOf<Int>(1, 2, 3, 4, 5),
        listOf<Int>(6, 7, 8, 9, 10)
    )
)



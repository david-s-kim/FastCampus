// while문 실습

var i = 0
while (i < 5) { // 1 -> i =0 , 2->i=10
    if (i % 2 == 0) {
        println("짝수")
    } else {
        println("홀수")
    }
    i++ // 이 부분을 제거하면 무한루프에 빠빈다.
}

var z = 10
do {
    println("시작")
} while (z > 20)

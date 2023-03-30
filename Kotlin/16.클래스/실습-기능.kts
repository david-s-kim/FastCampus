class FootballPlayer constructor(uniform: String, ball: String) {

    val uniform: String
    val ball: String

    init {
        this.uniform = uniform
        this.ball = ball
    }

    fun kick() {
        println("공을 찼다.")
        // 반복, 예외처리, 흐름제어

    }

    fun pass() {
        println("패스!")
    }
}

val footballPlayer = FootballPlayer("빨간색 유니폼", "축구공")
footballPlayer.kick()

val footballPlayer2 = FootballPlayer("빨간색 유니폼", "축구공")
footballPlayer2.pass()
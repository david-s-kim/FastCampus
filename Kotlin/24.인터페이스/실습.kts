interface Tiger {
    fun bite()
    fun goToBox()
}

class BackDoSanTiger : Tiger {
    override fun bite() {
        //구체적인 기능
    }

    override fun goToBox() {
        //구체적인 기능
    }
}

val backDoSanTiger: BackDoSanTiger = BackDoSanTiger()
backDoSanTiger.bite()
backDoSanTiger.goToBox()


interface Person { // constructor가 필요없다 어차피 안이 비어있기때문
    // 멤버들의 구현부가 없다.
    var dress: String
    fun eat()
    fun sleep(){
        println("잠을 잔다.") // 코틀린은 인터페이스 구현이 가능하다.
    }

}

class Student : Person {
    override var dress: String
        get() = "옷"
        set(value) {}

    final override fun eat() {
        // final -> 이 클래스를 상속하는 클래스에서 oberride를 못하게 한다.
        println("밥을 먹는다.")
    }

    override fun sleep() {
        println("잠을 잔다.")
    }

    fun study(){
        println("공부를 한다.")
    }
}


class Teacher: Person {
    override var dress: String
        get() = "정장"
        set(value) {}

    override fun eat() {
        println("밥을 먹는다.")
    }

    override fun sleep() {
        println("잠을 잔다.")
    }
}

val student: Student = Student()
student.eat()
student.sleep()






open class basicStats(var life: Int, var attack: Int, var defense: Int, var name: String) {
    var startslife: Int = 100

    fun attack() {
        startslife -= 10
        println($name+"가 공격합니다.")
    }

    fun defense() {
        println($name + "")
    }

    fun life() {

        if (startslife <= 0){
            println(""+ $name + "은 죽었습니다.")
        } else println("아직 살아 있습니다. 체력:"+$startslife)
    }
}

class Warrior() : basicStats(life, attack, defense, "Warrior") {
    fun attack(){

    }


}

class Knight() : basicStats(life, attack, defense, "Knight") {
    fun hardAttack(energy:Int){
        val initialEnergy: Int = 100
        initialEnergy -= 30
    }


}

class Monster() : basicStats(life, attack, defense, "Monster") {


}

val monster = Monster()

open class Warrior constructor(hp: Int, var power: Int, var armor: Int) {

    var isAlive: Boolean = true
        get() {
            if (field == true) println("Warrior 아직 살아 있다. 체력: ${this.hp}")
            else println("Warrior는 죽었습니다.")
            return field
        }
    var killCount: Int = 0

    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp

    }


    open fun attack(monster: Monster) {
        println("Warrior가 공격을 합니다.")
        if (!monster.defense(this)) {
            // Monster 죽음
            this.killCount += 1
            println("Monster를 처치했습니다. 현재 killCount : ${this.killCount}")
        }
    }

    fun defense(monster: Monster): Boolean {
        val damage: Int = monster.power - this.armor
        this.hp -= if (damage > 0) damage else 0
        return this.isAlive

    }

    fun levelUp(): Knight? {
        if (this.killCount > 5) {
            println("Knight로 레벨업 하였습니다.")
            return Knight(this)
        } else {
            println("레벨업을 할 수 없습니다. 부족한 KillCount ${this.killCount}")
            return null
        }
    }
}

class Knight constructor(warrior: Warrior) : Warrior(warrior.hp, warrior.power, warrior.armor) {
    var energy: Int = 0

    init {
        this.hp = warrior.hp
        this.power = warrior.power + 2
        this.armor = warrior.armor + 1
    }

    override fun attack(monster: Monster) {
        super.attack(monster)
        this.energy += 1
    }

    fun hardAttack(monster: Monster) {
        if (monster.isAlive && this.energy >= 3) {
            monster.hp -= this.power + 30
            this.energy -= 3
        } else println("에너지가 부족합니다. 에너지 : ${this.energy}")
    }
}

class Monster(hp: Int, var power: Int, var armor: Int) {

    var isAlive: Boolean = true
        get() {
            if (field == true) println("Monster는 아직 살아 있다. 체력: ${this.hp}")
            else println("Monster는 죽었습니다.")
            return field
        }
    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp
    }

    fun bite(warrior: Warrior) {
        println("Monster가 공격을 합니다.")
        warrior.defense(this)
    }

    fun defense(warrior: Warrior): Boolean {
        val damage: Int = warrior.power - this.armor
        this.hp -= if (damage > 0) damage else 0
        return this.isAlive
    }
}

val warrior = Warrior(1, 10, 5)
loop@ while (warrior.killCount < 10) {
    val monster = Monster(15, 8, 1)
    while (monster.isAlive) {
        warrior.attack(monster)
        monster.bite(warrior)
        if (!warrior.isAlive) {
            break@loop
        }

    }
}

val knight: Knight? = warrior.levelUp()

// 추가로 해볼만한 것들
// 1. Knight 클래스를 활용
// 2. Healer 클래스를 만들어서 Warrior를 회복 또는 부활 시키는 기능추가

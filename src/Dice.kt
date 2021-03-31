import kotlin.random.Random

class Dice {
    var value: Int = -1
    var locked: Boolean = false

    fun rollDice() {
        this.value = Random.nextInt(1, 7)
    }

    fun lockDice() {
        this.locked = true
    }

    fun resetDice() {
        this.value = -1;
        this.locked = false
    }
}
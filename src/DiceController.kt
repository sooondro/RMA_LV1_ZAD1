class DiceController {
    private val dice = Array(6) {
        Dice()
    }

    fun rollUnlockedDice() {
        for (dice in this.dice) {
            if (!dice.locked) {
                dice.rollDice()
            }
        }
    }

    fun resetDice() {
        for (dice in this.dice) {
            dice.resetDice()
        }
    }

    fun lockDiceByIndex(indexArray: List<Int>?) {
        for (i in indexArray!!) {
            this.dice[i].lockDice()
        }
    }

    fun printAllValues() {

        println("Dice values and their indexes:")
        this.dice.forEachIndexed { index, dice ->
            run {
                if (!dice.locked) {
                    println("index: ${index}, value: ${dice.value}")
                }
            }
        }

        var result = ""
        println("Unlocked dice:")
        for (dice in this.dice)
            if (!dice.locked)
                result += "${dice.value}, "
        println(result)
        result = ""
        println("Locked dice:")
        for (dice in this.dice)
            if (dice.locked)
                result += "${dice.value}, "
        println(result)
    }

    fun checkValues(): String {
        when {
            Validator.isYamb(convertResultToArray(this.dice)) -> {
                return "yamb"
            }
            Validator.isPoker(convertResultToArray(this.dice)) -> {
                return "poker"
            }
            Validator.isStraight(convertResultToArray(this.dice)) -> {
                return "straight"
            }
        }
        return ""
    }

    private fun convertResultToArray(result: Array<Dice>): Array<Int> {
        val resultArray = Array<Int>(6) { 0 }
        result.forEachIndexed { index, dice ->  resultArray[index] = dice.value }
        return resultArray
    }

}
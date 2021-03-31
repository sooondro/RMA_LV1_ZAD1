import java.util.Scanner

class GameController {
    private val diceController = DiceController()

    fun startGame() {
        var counter = 0
        val number = Scanner(System.`in`)
        var message = ""

        while (counter < 3) {
            println("${counter + 1}. throw")
            println("Enter 1 to roll the dice")
            if (number.nextInt() == 1) {
                diceController.rollUnlockedDice()
                diceController.printAllValues()
            } else continue
            println("To lock the dice, write their index with comma separating them, or just press enter to continue to the next throw")
            var enteredString = readLine()
            if (enteredString != "") {
                var parsedIndexes = enteredString?.split(",")?.map { it.toInt() }
                diceController.lockDiceByIndex(parsedIndexes)
            }
            message = diceController.checkValues()
            if (message != "")
                println(message)
            counter++
        }

        if (message == "")
            println("Game Over")
    }
}
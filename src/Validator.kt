class Validator {
    companion object {
        fun isYamb(values: Array<Int>): Boolean {
            val frequency = values.groupingBy { it }.eachCount()
            for ((k,v) in frequency) {
                if (v == 5 || v == 6)
                    return true
            }
            return false
        }

        fun isPoker(values: Array<Int>): Boolean {
            val frequency = values.groupingBy { it }.eachCount()
            for ((k,v) in frequency) {
                if (v == 4)
                    return true
            }
            return false
        }

        fun isStraight(values: Array<Int>): Boolean {
            val frequency = values.groupingBy { it }.eachCount()
            var counter = 0
            for ((k,v) in frequency) {
                if (v == 1)
                    counter++
            }
            if (counter == 4 || counter == 6) return true
            return false
        }
    }
}
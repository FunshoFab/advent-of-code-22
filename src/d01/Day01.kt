package d01

import readInput

private const val TOP_N_CALORIES = 3

class Day01 {
    fun part1(input: List<String>): Int {
        var currentCalories = 0
        var maxCalories = 0

        input.forEach {
            currentCalories = if (it.isBlank()) 0 else currentCalories + it.toInt()
            maxCalories = maxCalories.coerceAtLeast(currentCalories)
        }

        return maxCalories
    }

    fun part2(input: List<String>): Int {
        var currentCalories = 0
        val calories = mutableListOf<Int>()

        input.forEachIndexed { index, calorie ->
            if (calorie.isBlank()) {
                calories.add(currentCalories)
                currentCalories = 0
            } else {
                currentCalories += calorie.toInt()
                if (index == input.lastIndex) {
                    calories.add(currentCalories)
                }
            }
        }

        return calories.sortedDescending().take(TOP_N_CALORIES).sum()
    }
}

fun main() {
    Day01().run {
        val packageName = javaClass.`package`.name
        val sample = readInput("${packageName}/sample_input.txt")
        check(part1(sample) == 24000)
        check(part2(sample) == 45000)

        val puzzle = readInput("${packageName}/puzzle_input.txt")
        println(part1(puzzle))
        println(part2(puzzle))
    }
}

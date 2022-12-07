package d00

import readInput

class Day00 {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    Day00().run {
        val packageName = javaClass.`package`.name
        val sample = readInput("${packageName}/sample_input.txt")
        check(part1(sample) == 0)
        check(part2(sample) == 0)

        val puzzle = readInput("${packageName}/puzzle_input.txt")
        println(part1(puzzle))
        println(part2(puzzle))
    }
}

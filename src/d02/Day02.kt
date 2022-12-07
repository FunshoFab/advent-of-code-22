package d02

import d02.Score.*
import d02.Shape.*
import readInput

class Day02 {
    fun part1(input: List<String>): Int {
        val playerInputToShape = mapOf(
            'X' to ROCK,
            'Y' to PAPER,
            'Z' to SCISSORS
        )
        var totalScore = 0

        input.forEach {
            val (oppInput, playerInput) = it.split(" ")
            val oppShape = opponentShape[oppInput[0]]!!
            val playerShape = playerInputToShape[playerInput[0]]!!

            totalScore += calculatePlayerScore(oppShape, playerShape)
        }

        return totalScore
    }

    fun part2(input: List<String>): Int {
        val playerInputToScore = mapOf(
            'X' to LOSS,
            'Y' to DRAW,
            'Z' to WIN
        )
        var totalScore = 0

        input.forEach {
            val (oppInput, playerInput) = it.split(" ")
            val oppShape = opponentShape[oppInput[0]]!!
            val playerShape = when (playerInputToScore[playerInput[0]]!!) {
                DRAW -> oppShape
                WIN -> oppShape.conqueror()
                LOSS -> oppShape.victim()
            }
            totalScore += calculatePlayerScore(oppShape, playerShape)
        }

        return totalScore
    }

    private fun calculatePlayerScore(oppShape: Shape, playerShape: Shape): Int {
        val score = when (playerShape) {
            oppShape -> DRAW
            oppShape.conqueror() -> WIN
            else -> LOSS
        }
        return score.value + playerShape.value
    }
}

fun main() {
    Day02().run {
        val packageName = javaClass.`package`.name
        val sample = readInput("${packageName}/sample_input.txt")
        check(part1(sample) == 15)
        check(part2(sample) == 12)

        val puzzle = readInput("${packageName}/puzzle_input.txt")
        println(part1(puzzle))
        println(part2(puzzle))
    }
}

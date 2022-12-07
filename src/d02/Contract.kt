package d02

import d02.Shape.*

enum class Score(val value: Int) {
    WIN(6),
    DRAW(3),
    LOSS(0)
}

enum class Shape(val value: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

val opponentShape = mapOf(
    'A' to ROCK,
    'B' to PAPER,
    'C' to SCISSORS
)

fun Shape.conqueror(): Shape = when (this) {
    ROCK -> PAPER
    PAPER -> SCISSORS
    SCISSORS -> ROCK
}

fun Shape.victim(): Shape = when (this) {
    ROCK -> SCISSORS
    PAPER -> ROCK
    SCISSORS -> PAPER
}

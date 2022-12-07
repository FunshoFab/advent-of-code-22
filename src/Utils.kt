import java.io.File

/**
 * Reads lines from the given input file.
 */
fun readInput(name: String) = File("src", name).readLines()

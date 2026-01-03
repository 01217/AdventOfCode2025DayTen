import java.io.BufferedReader
import java.io.FileReader
import kotlin.collections.fold

fun main()  {
    val resultTaskOne = taskOne("inp/input.in")

    println("Task1: $resultTaskOne")
}

fun taskOne(filePath : String) : Long  {
    val patterns = readInput(filePath)

    var ans = 0L
    for (pattern in patterns.map { ButtonPattern.of(it)}) {
        ans += findShortest(pattern)
    }

    return ans
}

fun findShortest(pattern : ButtonPattern) : Int {
    return pattern.buttons
        .combinations()
        .sortedBy { it.size }
        .first { s -> s.fold(0) {p, n -> p xor n } == pattern.lights }
        .size
}


fun <T> List<T>.combinations(): List<Set<T>> =
    if (isEmpty()) listOf(emptySet())
    else drop(1)
        .combinations()
        .let { rest -> rest + rest.map { it + first() }
    }

fun readInput(filePath : String) : List<String> = BufferedReader(FileReader(filePath)).readLines()
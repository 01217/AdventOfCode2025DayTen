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
    for (pattern in patterns.map { ButtonPattern.compose(it)}) {
        ans += findShortest(pattern)
    }

    return ans
}

fun findShortest(pattern : ButtonPattern) : Int {
    return pattern.buttons
        .pSet()
        .sortedBy { it.size }
        .first { s -> s.fold(0) {p, n -> p xor n } == pattern.lights }
        .size
}


fun <T> List<T>.pSet(): List<Set<T>> =
    fold(listOf(emptySet())) {
        carry, e -> carry + carry.map {it + e}
    }

fun readInput(filePath : String) : List<String> = BufferedReader(FileReader(filePath)).readLines()
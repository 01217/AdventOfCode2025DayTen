data class ButtonPattern(val lights: Int, val buttons: List<Int>)
{
    companion object {
        fun compose(input: String): ButtonPattern =
            ButtonPattern(
                lights = input.lightsToInt(),
                buttons = input
                    .substringAfter(" ")
                    .substringBefore(" {")
                    .split(" ")
                    .map { it.buttonsToInt() },
            )

        private fun String.lightsToInt(): Int =
            this.substringAfter("[")
                .substringBefore("]")
                .reversed()
                .fold(0) { carry, next ->
                    (carry shl 1) or if (next == '#') 1 else 0
                }

        private fun String.buttonsToInt(): Int =
            this.substringAfter("(")
                .substringBefore(")")
                .split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .fold(0) { carry, next ->
                    carry or (1 shl next.toInt())
                }
    }
}
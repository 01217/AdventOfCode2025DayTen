import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test {

    @Test
    @DisplayName("task one test")
    fun taskOneTest() {
        val expectedResult = 7L

        Assertions.assertEquals(expectedResult, taskOne("inp/test.in"))
    }

    @Test
    @DisplayName("task two test")
    fun taskTwoTest() {
        val expectedResult = 0L

        Assertions.assertEquals(expectedResult, taskTwo("inp/test.inp"))
    }
}
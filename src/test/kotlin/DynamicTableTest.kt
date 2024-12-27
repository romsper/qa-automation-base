import helpers.BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import pages.DynamicTablePage

class DynamicTableTest: BaseTest() {

    @Test
    fun checkSpiderMan() {
        val spiderMan = DynamicTablePage()
            .open()
            .getSuperheroes().firstOrNull { it.name == "Spider-Man"}

        spiderMan!!.name shouldBe "Spider-Man"
    }
}
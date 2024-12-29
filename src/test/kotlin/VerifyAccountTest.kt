import helpers.BaseTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import pages.VerifyAccountPage

class VerifyAccountTest: BaseTest() {

    @Test
    fun verifyAccount() {
        val message = VerifyAccountPage()
            .open()
            .enterCode()
            .pressEnter()
            .getMessage()

        message shouldBe "Success"
    }
}
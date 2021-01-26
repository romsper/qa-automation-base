package test.backend

import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotBeBlank
import io.qameta.allure.*
import main.backend.extention.Functions.Companion.getAsObject
import main.backend.extention.Functions.Companion.getErrorBody
import main.backend.extention.Functions.Companion.jsonToObject
import main.backend.interfaces.IUsers
import main.backend.pojo.ExampleName
import org.junit.jupiter.api.*

//TODO Keep in mind that it's just an example ;)

@Feature("User")
@Story("getUsers")
@Tags(Tag("user"), Tag("regress"))
class UserTest : IUsers {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Issue("JIRA-123")
    @TmsLink("TR-15")
    @DisplayName("Positive -> Get users list")
    fun checkUserPositive() {
        val user = user.getUsers().getAsObject()

        user.results.first().id.value.shouldNotBeBlank()
        user.results.size.shouldBeGreaterThanOrEqual(1)
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Issue("JIRA-123")
    @TmsLink("TR-15")
    @DisplayName("Negative -> Get users list")
    fun checkUserNegative() {
        val error = user.getUsers().getErrorBody().jsonToObject(ExampleName::class.java)

        error.first.shouldContain("Error")
    }
}
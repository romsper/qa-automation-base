package test.frontend

import io.kotest.matchers.booleans.shouldBeTrue
import io.qameta.allure.*
import main.frontend.helpers.BaseTest
import main.frontend.elements.AuthElem
import main.frontend.pages.AuthPage
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Feature("Authorization")
@Story("Authorization")
@Tags(Tag("auth"), Tag("regress"))
class AuthTest : BaseTest() {

    @ParameterizedTest(name = "Negative -> Check email validation {0}")
    @ValueSource(strings = ["asd@asd.com", "asd"])
    @Severity(SeverityLevel.BLOCKER)
    @Issue("JIRA-123") @TmsLink("TR-15")
    fun badAuthTest(email: String) {
        AuthPage()
                .authElem()
                .typeLoginAndPass(email = email, pass = "asdfg123")
                .submitClick()

        AuthElem().errorMsgIsDisplayed().shouldBeTrue()
    }
}
package test.frontend

import main.frontend.helpers.BaseTest
import main.frontend.elements.AuthElem
import io.qameta.allure.Feature
import io.qameta.allure.Story
import main.frontend.pages.AuthPage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@Feature("Authorization")
@Story("Authorization")
@Tags(Tag("auth"), Tag("regress"))
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthTest : BaseTest() {

    @Test
    fun badAuthTest() {
        AuthPage()
                .open("/")
                .authElem()
                .typeLoginAndPass(email = "asd@asd.com", pass = "asdfg123")
                .submitClick()

        assertThat(AuthElem().errorMsgIsDisplayed()).isTrue()
    }
}
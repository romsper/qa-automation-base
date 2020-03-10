package test.login

import io.qameta.allure.*
import main.enums.LoginErrorEnum
import main.enums.StringsEnum
import main.helpers.TestBase
import main.helpers.screen
import main.helpers.testRail.TestRail
import main.helpers.testRail.TestRailIdProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import java.lang.Thread.sleep

@Feature("Login")
@Story("Login")
@Tags(Tag("login"), Tag("regression"))
@ExtendWith(TestRailIdProvider::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoginTest : TestBase() {

    @Test
    @TestRail("63")
    @TmsLink("63")
    @DisplayName("[Login] Verify successful login")
    fun successLogin() {
        screen.login
                .typePassword(StringsEnum.LOGIN_DEFAULT_PASSWORD.txt)
                .tapNextButton()
        val chatIsAppear = screen.chats.addChatButtonIsAppear()

        assertThat(chatIsAppear).isTrue()
    }

    @Test
    @TestRail("64")
    @TmsLink("64")
    @DisplayName("[Login] Verify error message - Input incorrect password")
    fun threeWrongPasswordTest() {
        val errorText = screen.login
                .typePassword(StringsEnum.TEXT_BLABLABLA.txt)
                .tapNextButton()
                .getPasswordErrorText()

        assertThat(errorText).isEqualTo(LoginErrorEnum.PASSWORD_WRONG_1.error)
    }

    @Test
    @TestRail("282")
    @TmsLink("282")
    @DisplayName("[Login] Verify login attempts")
    fun attempPopUpTest() {
        val error = screen.login
                .typePasswordFewTimesAndLogin(StringsEnum.TEXT_BLABLABLA.txt, 4)
                .typeTextToLastPasswordAttemptField(StringsEnum.LOGIN_ATTEMP_PASSWORD.txt)
                .tapContinueButton()
                .getPasswordErrorText()
        val attempPopupDisappear = screen.login.attempPopupDisappear()

        screen.login.authByDefaultCredentials()
        val chatIsAppear = screen.chats.addChatButtonIsAppear()

        assertThat(error).isEqualTo(StringsEnum.LOGIN_WIPE_ERROR.txt)
        assertThat(attempPopupDisappear).isFalse()
        assertThat(chatIsAppear).isTrue()
    }
}
package main.screens.authorization

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element

class LoginScreenAndroid : LoginScreen() {
    override var AUTH_PASSWORD = element(byId("password"))
    override var AUTH_PASSWORD_ERROR = element(byId("textinput_error"))
    override var AUTH_NEXT_BUTTON = element(byId("email_sign_in_button"))
    override var AUTH_LAST_ATTEMP_FIELD = element(byId("lastAttempUnlockField"))
    override var AUTH_LAST_ATTEMP_CONTINUE = element(byId("lastAttemptContinueButton"))
}
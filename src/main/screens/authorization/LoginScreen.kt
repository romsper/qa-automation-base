package main.screens.authorization

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.sleep
import io.qameta.allure.Step
import main.enums.StringsEnum

open class LoginScreen {
    protected open var AUTH_PASSWORD = element(byId(""))
    protected open var AUTH_PASSWORD_ERROR = element(byId(""))
    protected open var AUTH_NEXT_BUTTON = element(byId(""))
    protected open var AUTH_LAST_ATTEMP_FIELD = element(byId(""))
    protected open var AUTH_LAST_ATTEMP_CONTINUE = element(byId(""))

    @Step("Type a password")
    fun typePassword(password: String): LoginScreen {
        AUTH_PASSWORD.shouldBe(appear)
        AUTH_PASSWORD.value = password
        return this
    }

    @Step("Tap the next button")
    fun tapNextButton(): LoginScreen {
        AUTH_NEXT_BUTTON.shouldBe(appear)
        AUTH_NEXT_BUTTON.click()
        return this
    }

    @Step("Get error text")
    fun getPasswordErrorText(): String {
        AUTH_PASSWORD_ERROR.shouldBe(appear)
        return AUTH_PASSWORD_ERROR.text
    }

    @Step("Type text to last password attempt filed")
    fun typeTextToLastPasswordAttemptField(text: String): LoginScreen {
        AUTH_LAST_ATTEMP_FIELD.shouldBe(appear)
        AUTH_LAST_ATTEMP_FIELD.value = text
        return this
    }

    @Step("Tap to continue button")
    fun tapContinueButton(): LoginScreen {
        AUTH_LAST_ATTEMP_CONTINUE.shouldBe(appear)
        AUTH_LAST_ATTEMP_CONTINUE.click()
        return this
    }

    @Step("Attemp popup disappear")
    fun attempPopupDisappear(): Boolean {
        AUTH_LAST_ATTEMP_FIELD.shouldBe(disappear)
        return AUTH_LAST_ATTEMP_FIELD.isDisplayed
    }

    //---

    @Step("Type password a few times and tap to login")
    fun typePasswordFewTimesAndLogin (password: String, times: Int): LoginScreen {
        AUTH_PASSWORD.shouldBe(appear)
        for (i in 1..times) {
            AUTH_PASSWORD.value = password
            AUTH_NEXT_BUTTON.click()
        }
        AUTH_LAST_ATTEMP_FIELD.shouldBe(appear)
        return this
    }

    @Step("Authorization by default credentials")
    fun authByDefaultCredentials(): LoginScreen {
        typePassword(StringsEnum.LOGIN_DEFAULT_PASSWORD.txt)
        tapNextButton()
        return this
    }
}
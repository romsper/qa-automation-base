package frontend.pages

import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.sleep
import io.qameta.allure.Step
import frontend.elements.AuthElem

class AuthPage {
    private val inpEmail get() = element(byId("index_email"))
    private val inpPass get() = element(byId("index_pass"))
    private val btnSubmit get() = element(byId("index_login_button"))
    private val errorMsg get() = element(byClassName("msg_text"))

    @Step("Open page: {url}")
    fun open(url: String = "/login"): AuthPage {
        Selenide.open(url)
        return this
    }

    @Step("Type Login and Pass")
    fun typeLoginAndPass(email: String, pass: String): AuthPage {
        inpEmail.value = email
        inpPass.value = pass
        return this
    }

    @Step("Click Submit")
    fun submitClick(): AuthPage {
        btnSubmit.click()
        return this
    }

    @Step("Is error message displayed")
    fun errorMsgIsDisplayed(): Boolean {
        return errorMsg.isDisplayed
    }

}
package frontend.elements

import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step

class AuthElem {
    private val inpEmail get() = element(byId("index_email"))
    private val inpPass get() = element(byId("index_pass"))
    private val btnSubmit get() = element(byId("index_login_button"))
    private val errorMsg get() = element(byClassName("msg_text"))

    @Step("Type Login and Pass")
    fun typeLoginAndPass(email: String, pass: String): AuthElem {
        inpEmail.value = email
        inpPass.value = pass
        return this
    }

    @Step("Click Submit")
    fun submitClick(): AuthElem {
        btnSubmit.click()
        return this
    }

    @Step("Get error msg")
    fun errorMsgIsDisplayed(): Boolean {
        return errorMsg.isDisplayed
    }
}
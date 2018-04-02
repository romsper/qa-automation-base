package main.java.project_A.elements

import com.codeborne.selenide.ElementsContainer
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.sleep
import frontend.helpers.element
import io.qameta.allure.Step

class AuthElem : ElementsContainer() {

    @Step("Type Login and Pass")
    fun typeLoginAndPass(email: String, pass: String): AuthElem {
        element(byId("index_email")).setValue(email)
        element(byId("index_pass")).setValue(pass)
        return this
    }

    @Step("Click Submit")
    fun submitClick(): AuthElem {
        element(byId("index_login_button")).click()
        sleep(500)
        return this
    }

    @Step("Get error msg")
    fun errorMsgIsDisplayed(): Boolean {
        return element(byClassName("msg_text")).isDisplayed
    }
}
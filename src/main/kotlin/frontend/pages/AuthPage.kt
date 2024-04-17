package frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import io.qameta.allure.Step
import frontend.elements.AuthElem

class AuthPage {

    @Step("Open page: {url}")
    fun open(url: String): AuthPage {
        Selenide.open(url)
        return this
    }

    fun authElem(): AuthElem {
        return AuthElem()
    }

}
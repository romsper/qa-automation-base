package main.java.project_A.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import frontend.elements.AuthElem
import io.qameta.allure.Step

class AuthPage {

    @Step("Open page {0}")
    fun open(url: String): AuthPage {
        Selenide.open(url)
        sleep(500)
        return this
    }

    fun authElem(): AuthElem {
        return AuthElem()
    }

}
package main.elements.header

import com.codeborne.selenide.Condition.appear
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step

open class TopNavigationElems {
    protected open var HEADER_CLOSE_BUTTON = element(byId(""))
    protected open var HEADER_BACK_BUTTON = element(byId(""))
    protected open var HEADER_VAULT_TABS = elements(byClassName(""))
    protected open var CONTACT_NAME = element(byId(""))
    protected open var DURATION_TIME = element(byId(""))

    @Step("Tap to back button")
    fun tapBackButton(): TopNavigationElems {
        HEADER_BACK_BUTTON.shouldBe(appear)
        HEADER_BACK_BUTTON.click()
        return this
    }

    @Step("Tap to vault tab")
    fun tapVaultTab(tab: String): TopNavigationElems {
        HEADER_VAULT_TABS.first { it.text.contains(tab) }.click()
        return this
    }

    //---

    @Step("Tap to back button twice")
    fun tapBackButtonTwice(): TopNavigationElems {
        HEADER_BACK_BUTTON.shouldBe(appear)
        HEADER_BACK_BUTTON.click()
        HEADER_BACK_BUTTON.click()
        return this
    }
}
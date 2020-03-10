package main.elements.navigation

import com.codeborne.selenide.Condition.appear
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step

open class BottomNavigationElems {
    protected open var NAV_CHATS = element(byId(""))
    protected open var NAV_CONTACTS = element(byId(""))
    protected open var NAV_VAULT = element(byId(""))

    @Step("Tap to chats")
    open fun tapChatsButton(): BottomNavigationElems {
        NAV_CHATS.shouldBe(appear)
        NAV_CHATS.click()
        return this
    }

    @Step("Tap to contacts")
    fun tapContactsButton(): BottomNavigationElems {
        NAV_CONTACTS.shouldBe(appear)
        NAV_CONTACTS.click()
        return this
    }

    @Step("Tap to vault")
    fun tapVaultButton(): BottomNavigationElems {
        NAV_VAULT.shouldBe(appear)
        NAV_VAULT.click()
        return this
    }
}
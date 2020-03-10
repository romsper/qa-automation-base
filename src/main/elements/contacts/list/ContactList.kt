package main.elements.contacts.list

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.SelenideElement

open class ContactList(val item: SelenideElement) {
    open var CONTACT_CHECKBOX = item.find(byId(""))
    open var CONTACT_AVATAR = item.find(byId(""))
    open var CONTACT_NAME = item.find(byId(""))
}

data class ContactListItem(
        val checkbox: SelenideElement,
        val avatar: SelenideElement,
        val name: String
)
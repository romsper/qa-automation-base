package main.elements.contacts.contactsHelper

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import main.elements.contacts.list.ContactListFactory
import main.elements.contacts.list.ContactListItem

open class ContactHelper {
    protected open var CAT_CONTACT_LIST = elements(byId(""))

    private fun convertListToObject(): List<ContactListItem> {
        CAT_CONTACT_LIST.first().shouldBe(Condition.appear)
        return CAT_CONTACT_LIST.map { ContactListFactory().get(it) }
                .map { ContactListItem(
                        checkbox = it.CONTACT_CHECKBOX,
                        avatar = it.CONTACT_AVATAR,
                        name = it.CONTACT_NAME.text
                ) }
    }

    @Step("Tap to contact")
    fun tapContactByName(name: String): ContactHelper {
        CAT_CONTACT_LIST.first().shouldBe(Condition.appear)
        convertListToObject().first { it.name.contains(name) }.avatar.click()
        return this
    }
}
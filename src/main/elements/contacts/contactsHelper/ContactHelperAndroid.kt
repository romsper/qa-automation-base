package main.elements.contacts.contactsHelper

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.elements

class ContactHelperAndroid: ContactHelper() {
    override var CAT_CONTACT_LIST = elements(byId("contactItem"))
}
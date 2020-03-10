package main.elements.contacts.list

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.SelenideElement

class ContactListAndroid(newItem: SelenideElement): ContactList(newItem) {
    override var CONTACT_CHECKBOX = newItem.find(byId("contactsCheckBox"))
    override var CONTACT_AVATAR = newItem.find(byId("imageView1"))
    override var CONTACT_NAME = newItem.find(byId("textView1"))
}
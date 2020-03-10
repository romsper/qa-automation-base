package main.elements.contacts.list

import com.codeborne.selenide.Selenide.page
import com.codeborne.selenide.SelenideElement
import main.helpers.InitDriverProvider
import org.junit.jupiter.api.fail

class ContactListFactory {
    fun get(item: SelenideElement): ContactList =
            when (InitDriverProvider().platform) {
                "Android" -> ContactListAndroid(item)
                "iOS" -> ContactListIOS(item)
                else -> fail("Wrong page")
            }
}
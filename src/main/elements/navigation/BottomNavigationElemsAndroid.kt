package main.elements.navigation

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element

class BottomNavigationElemsAndroid: BottomNavigationElems() {
    override var NAV_CHATS = element(byId("navigation_chat"))
    override var NAV_CONTACTS = element(byId("navigation_contacts"))
    override var NAV_VAULT = element(byId("navigation_vault"))
}
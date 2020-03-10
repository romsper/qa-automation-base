package main.elements.header

import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements

class TopNavigationElemsAndroid: TopNavigationElems() {
    override var HEADER_CLOSE_BUTTON = element(byId("navClose"))
    override var HEADER_BACK_BUTTON = element(byId("navback"))
    override var HEADER_VAULT_TABS = elements(byClassName("android.widget.TextView"))
    override var CONTACT_NAME = element(byId("contactName"))
    override var DURATION_TIME = element(byId("destructionTimeDisplay"))
}
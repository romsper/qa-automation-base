package main.elements.header

import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide

class TopNavigationElemsIOS: TopNavigationElems() {
    override var HEADER_BACK_BUTTON = Selenide.element(Selectors.byId("navBack"))
}
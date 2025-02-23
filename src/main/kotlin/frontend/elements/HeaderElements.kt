package frontend.elements

import com.codeborne.selenide.Selenide.elements
import frontend.helpers.Wrappers.Companion.byDataTarget
import io.qameta.allure.Step
import org.example.pages.simpleWine.SearchPage

class HeaderElements {
    private val listHeadersCategory get() = elements(byDataTarget("header-main-menu"))

    @Step("Click on header link: {name}")
    fun clickHeaderLink(name: String): SearchPage {
        listHeadersCategory.first { it.text == name }.click()
        return SearchPage()
    }
}
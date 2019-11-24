package main.selenide.elements

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import main.selenide.helpers.pressKeyEnter

interface IMainActivityElem {

    private val viewSearchCity get() = element(byId("action_search"))
    private val editTextSearchCity get() = element(byId("searchTextView"))

    @Step("Search city by name")
    fun searchCityByName(city: String) {
        viewSearchCity.click()
        editTextSearchCity.apply {
            value = city
            pressKeyEnter()
        }
    }
}
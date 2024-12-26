package pages

import helpers.PlaywrightObject.page
import io.qameta.allure.Step

class SearchPage {
    private val inpQuery get() = page?.locator("textarea[name='q']")
    private val txtTitle get() = page?.locator("div[data-attrid='title']")

    @Step("Get query text")
    fun getQueryText(): String {
        return inpQuery!!.innerText()
    }

    @Step("Get title")
    fun getTitle(): String {
        return txtTitle!!.innerText()
    }
}
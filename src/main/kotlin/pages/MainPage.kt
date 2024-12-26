package pages

import com.microsoft.playwright.Keyboard
import io.qameta.allure.Step
import helpers.PlaywrightObject.page

class MainPage {
    private val inpQuery get() = page?.locator("textarea[name='q']")

    @Step("Type search query: {query}")
    fun typeQuery(query: String): MainPage {
        inpQuery?.fill(query)
        return this
    }

    @Step("Submit query")
    fun submitQuery(): SearchPage {
        page!!.keyboard().press("Enter", Keyboard.PressOptions().setDelay(100.0))
        return SearchPage()
    }

    @Step("Go to Search Page")
    fun goToSearchPage(): SearchPage {
        return SearchPage()
    }
}
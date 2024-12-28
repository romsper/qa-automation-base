package pages

import com.microsoft.playwright.Locator
import helpers.PlaywrightObject.page

class DynamicTablePage {
    private val listSuperheroes get() = page?.locator("//*[@id='tbody']/tr")?.all()

    fun open(): DynamicTablePage {
        page?.navigate("${System.getProperty("TEST_HOST")}/apps/dynamic-table/")
        return this
    }

    fun getSuperheroes(): List<SuperheroObject> {
        return listSuperheroes!!.map { Superhero(it) }
            .map {
                SuperheroObject(
                    name = it.name.innerText(),
                    email = it.email.innerText(),
                )
            }
    }
}

// This class is a wrapper for the locator of the item in the list
// Similar bug in Playwright: https://github.com/microsoft/playwright/issues/12529
class Superhero(item: Locator) {
    val name = item.locator("xpath=.//div[@class='ml-4']/div[1]")
    val email = item.locator("xpath=.//div[@class='ml-4']/div[2]")
}

data class SuperheroObject(
    val name: String,
    val email: String
)
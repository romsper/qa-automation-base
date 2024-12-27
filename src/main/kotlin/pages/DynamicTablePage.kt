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
                    status = it.status.innerText(),
                    realName = it.realName.innerText()
                )
            }
    }
}

// This class is a wrapper for the locator of the item in the list
// Similar bug in Playwright: https://github.com/microsoft/playwright/issues/12529
// Reported in NEW issue: https://github.com/microsoft/playwright/issues/34147
class Superhero(item: Locator) {
    val name = item.locator(".div[@class='ml-4']/div[1]")
    val email = item.locator(".//div[@class='ml-4']/div[2]")
    val status = item.locator(".//div[contains(@class, 'px-2')]")
    val realName = item.locator(".//div[contains(@class, 'px-6')]")
}

data class SuperheroObject(
    val name: String,
    val email: String,
    val status: String,
    val realName: String,
)
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

class Superhero(item: Locator) {
    val name = item.locator("xpath=.//div[@class='ml-4']/div[1]")
    val email = item.locator("xpath=.//div[@class='ml-4']/div[2]")
    val status = item.locator("xpath=.//td[2]/span")
    val realName = item.locator("xpath=.//td[3]/span")
}

data class SuperheroObject(
    val name: String,
    val email: String,
    val status: String,
    val realName: String,
)
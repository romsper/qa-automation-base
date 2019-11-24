package test.selenide

import com.codeborne.selenide.Selenide.sleep
import io.qameta.allure.Feature
import io.qameta.allure.Story
import main.selenide.helpers.TestBase
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@Feature("Search")
@Story("Search")
@Tags(Tag("search"), Tag("regress"))
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SelenideTest : TestBase() {

    @Test
    fun checkSearchTest() {
        mainActivity.searchCityByName("Vancouver")
        sleep(10000)
    }
}
package test.appium

import main.appium.helpers.BaseTest
import io.qameta.allure.Feature
import io.qameta.allure.Story
import main.appium.helpers.InitDriverProviderAppium
import main.appium.activities.MainActivity
import main.appium.helpers.wait
import org.junit.jupiter.api.*

@Feature("Search")
@Story("Search")
@Tags(Tag("search"), Tag("regress"))
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppiumTest : BaseTest() {

    @Test
    fun badAuthTest() {
        authPage.chooseCity("Vancouver")
        waitInSec(10)
    }
}
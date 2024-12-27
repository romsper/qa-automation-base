package google

import helpers.BaseTest
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import pages.google.MainPage

@Feature("Search")
@Story("Search results")
class GoogleSearchTest: BaseTest() {

    @Test
    @DisplayName("Check Search results")
    @Tags(Tag("smoke"), Tag("regression"))
    fun checkSearchQuery() {
        val title = MainPage()
            .typeQuery("Playwright")
            .submitQuery()
            .getTitle()

        title shouldBe "Playwright"
    }
}
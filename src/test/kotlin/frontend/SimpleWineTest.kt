package frontend

import io.qameta.allure.*
import frontend.helpers.BaseTest
import frontend.pages.MainPage
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.*

@Feature("Simple Wine")
@Story("Cart")
@Tags(Tag("cart"), Tag("regress"))
class SimpleWineTest : BaseTest() {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Issue("JIRA-123") @TmsLink("TR-15")
    @DisplayName("Search for wine in the catalog")
    fun addWineToCartTest() {
        val listProducts = MainPage()
            .open()
            .clickAgePopup()
            .goToHeader()
            .clickHeaderLink("Вино")
            .getProductItems()

        listProducts.forEach {
            println("Verifying wine: ${it.name}")
            it.name shouldContain "Вино"
        }
    }
}
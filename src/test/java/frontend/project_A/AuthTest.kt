package frontend.project_A

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import main.java.helpers.BaseTest
import main.java.project_A.elements.AuthElem
import main.java.project_A.pages.AuthPage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("auth")
class AuthTest : BaseTest() {

    @AfterEach
    fun clearCache() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }

    @Test
    @DisplayName("Authorization test")
    fun badAuthTest() {
        AuthPage()
                .open("/")
                .authElem()
                .typeLoginAndPass(email = "asd@asd.com", pass = "asdfg123")
                .submitClick()
        assertThat(AuthElem().errorMsgIsDisplayed()).isTrue()
    }
}
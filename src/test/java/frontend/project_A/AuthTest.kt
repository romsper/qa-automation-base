package frontend.project_A

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import main.java.helpers.BaseTest
import main.java.project_A.elements.AuthElem
import main.java.project_A.pages.AuthPage
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

@Test(groups = ["auth"])
class AuthTest : BaseTest() {

    @AfterMethod(alwaysRun = true)
    fun clearCache() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }

    @Test(testName = "Authorization test")
    fun badAuthTest() {
        AuthPage()
                .open("/")
                .authElem()
                .typeLoginAndPass(email = "asd@asd.com", pass = "asdfg123")
                .submitClick()
        assertThat(AuthElem().errorMsgIsDisplayed()).isTrue()
    }
}
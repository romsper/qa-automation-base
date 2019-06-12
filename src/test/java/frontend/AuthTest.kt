package frontend

import frontend.elements.AuthElem
import frontend.helpers.BaseTest
import main.java.project_A.pages.AuthPage
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

@Test(groups = ["auth"])
class AuthTest : BaseTest() {

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
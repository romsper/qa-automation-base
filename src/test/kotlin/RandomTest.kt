import com.microsoft.playwright.Keyboard
import org.example.helpers.BaseTest
import org.example.helpers.PlaywrightObject
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

class RandomTest: BaseTest() {

    @Test
    @Tags(Tag("smoke"))
    fun browser_0Test() {
        PlaywrightObject.page!!.fill("textarea[name='q']", "Playwright")
        PlaywrightObject.page!!.keyboard().press("Enter", Keyboard.PressOptions().setDelay(100.0))

        Thread.sleep(5000)
    }

    @Test
    @Tags(Tag("smoke"))
    fun browser_1Test() {
        PlaywrightObject.page!!.fill("textarea[name='q']", "Playwright")
        PlaywrightObject.page!!.keyboard().press("Enter", Keyboard.PressOptions().setDelay(100.0))

        Thread.sleep(5000)
    }
}
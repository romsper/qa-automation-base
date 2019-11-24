package main.appium.helpers

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import main.appium.activities.MainActivity
import org.junit.jupiter.api.AfterEach

open class BaseTest : InitDriverProviderAppium {
    private val driver by lazy { getAndroidDriver() }
    val authPage = MainActivity(driver)

    @AfterEach
    fun clearCache() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }

    fun waitInSec(second: Long) {
        driver.wait(second)
    }

}
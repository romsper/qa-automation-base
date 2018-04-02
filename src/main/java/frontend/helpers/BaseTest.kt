package main.java.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.junit.jupiter.api.AfterEach

open class BaseTest {

    init {
        Configuration.browser = InitDriverProvider()::class.java.name
    }

    @AfterEach
    fun clearCaches() {
        WebDriverRunner.clearBrowserCache()
        Selenide.clearBrowserCookies()
    }
}
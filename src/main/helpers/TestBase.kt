package main.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver

open class TestBase {
    private val appium = AppiumService()

    init {
        Configuration.browser = InitDriverProvider::class.java.name
    }

    @BeforeAll
    fun startAppium() {
        appium.checkIfServerIsRunning(4723)
        appium.startServer()
    }

    @AfterAll
    fun stopAppium() {
        closeWebDriver()
        appium.stopServer()
    }

    @BeforeEach
    fun initDriver() {
        closeWebDriver()
        open()
    }

    @AfterEach()
    fun closeDriver() {
        closeWebDriver()
    }
}

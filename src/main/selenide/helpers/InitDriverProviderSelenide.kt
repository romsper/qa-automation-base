package main.selenide.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

open class InitDriverProviderSelenide : WebDriverProvider {

    override fun createDriver(capabilities: DesiredCapabilities): WebDriver =
            DesiredCapabilities().apply {
                setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
                setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
                setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0")
                setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
                setCapability(MobileCapabilityType.APP, "/Users/romsper/Desktop/weather.apk")
            }.run {
                AndroidDriver<SelenideElement>(URL("http://0.0.0.0:4723/wd/hub"), this) }

    init {
        Configuration.startMaximized = false
        Configuration.browserSize = null
    }
}
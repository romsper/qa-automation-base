package frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverProvider
import backend.helpers.Properties.Companion.properties
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

open class InitDriverProvider : WebDriverProvider {

    init {
        Configuration.baseUrl = "https://vk.com"
        Configuration.browserSize = "1366x768"
        Configuration.timeout = 15000
        Configuration.reopenBrowserOnFail = true

//        Proxy configuration for Selenide
//        Configuration.proxyEnabled = true
//        Configuration.proxyHost =
//        Configuration.fileDownload = FileDownloadMode.PROXY
    }

    private var SELENOID_HUB_HOST = System.getProperty("SELENOID_HUB_HOST") ?:  "localhost"

    override fun createDriver(capabilities: Capabilities): WebDriver {
        return when (properties().browserName) { // Feel free to use System.getProperty instead of Properties
            "chrome" -> {
                ChromeOptions().apply {
                    setCapability("browserVersion", properties().browserVersion)
                    setCapability("selenoid:options",
                        mapOf("enableVNC" to true, "acceptInsecureCerts" to true))
                    addArguments("--disable-gpu")
                }
            }
            else -> throw Error("Browser is not defined")
        }
            .run { RemoteWebDriver(URL("http://$SELENOID_HUB_HOST:4444/wd/hub"), this) }
            .apply { this.fileDetector = LocalFileDetector() }
    }
}

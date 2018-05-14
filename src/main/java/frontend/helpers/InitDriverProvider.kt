package frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverProvider
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

open class InitDriverProvider : WebDriverProvider {

    var HUB_URL = if (System.getProperty("HUB_URL").isNullOrEmpty()) "localhost" else System.getProperty("HUB_URL")

    override fun createDriver(capabilities: DesiredCapabilities): RemoteWebDriver {
        val chromeOptions = ChromeOptions()
        chromeOptions.setCapability("version", "65")
        chromeOptions.setCapability("enableVNC", true)

        return RemoteWebDriver(URL("http://$HUB_URL:4444/wd/hub"), chromeOptions)
    }

    init {
        Configuration.baseUrl = "https://vk.com"
        Configuration.browserSize = "1920x1080"
        Configuration.collectionsTimeout = 15000
        Configuration.reopenBrowserOnFail = true
    }
}
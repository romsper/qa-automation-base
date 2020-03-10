package main.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.junit.jupiter.api.fail
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

open class InitDriverProvider: WebDriverProvider {

    init {
        Configuration.startMaximized = false
        Configuration.browserSize = null
        Configuration.timeout = 10000
    }

    val HUB_URL = "http://0.0.0.0:4723/wd/hub"

    val platform = System.getProperty("platform") ?: "Android"
    val apk_path = System.getProperty("apk.path") ?: "/Users/romsper/Documents/bitbucket/skyecc-2dot1/app/build/outputs/apk/dev/debug/app-dev-debug.apk"
    val app_path = System.getProperty("app.path") ?: "/Users/romsper/Library/Developer/Xcode/DerivedData/SkyECC-v2-gxmtrdxutnsyzpffrtpnkieyoagm/Build/Products/Debug-iphonesimulator/SkyECC-v2.app"
    val android_version = System.getProperty("android.version") ?: "10"
    val ios_version = System.getProperty("ios.version") ?: "13.3"
    val device_udid = System.getProperty("device.udid") ?: "A210FD6F-F957-407E-9080-1A05B56E1AC1"
    val device_name = System.getProperty("device.name") ?: "Pixel"

    val jenkins_os_version = when (platform)
    {
        "Android" -> android_version
        "iOS" -> ios_version
        else -> "Wrong platform name!"
    }

    override fun createDriver(capabilities: DesiredCapabilities): WebDriver {
        return when (platform) {
            "Android" -> DesiredCapabilities().apply {
                setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, platform)
                setCapability(AndroidMobileCapabilityType.VERSION, android_version)
                setCapability(MobileCapabilityType.DEVICE_NAME, device_name)
                setCapability(MobileCapabilityType.APP, apk_path)

                setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2)
                setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "se.skyglobal.app.skyapi")
                setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "se.skyglobal.app.ui.SplashActivityChat")
                setCapability(AndroidMobileCapabilityType.NO_SIGN, true)
                setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
                setCapability(MobileCapabilityType.NO_RESET, true)
                setCapability(MobileCapabilityType.FULL_RESET, false)
                setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true)
            }.run { AndroidDriver<SelenideElement>(URL(HUB_URL), this) }

            "iOS" -> DesiredCapabilities().apply {
                setCapability(IOSMobileCapabilityType.PLATFORM_NAME, platform)
                setCapability(MobileCapabilityType.PLATFORM_VERSION, ios_version)
                setCapability(MobileCapabilityType.DEVICE_NAME, device_name)
                setCapability(MobileCapabilityType.UDID, device_udid)
                setCapability(MobileCapabilityType.APP, app_path)

                setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST)
                setCapability(IOSMobileCapabilityType.APP_NAME, "se.skyglobal.ios")
                setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "iPhone Developer")
                setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "965PRB522J")
                setCapability(MobileCapabilityType.NO_RESET, true)
                setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true)
            }.run { IOSDriver<SelenideElement>(URL(HUB_URL), this) }

            else -> fail { "Wrong PLATFORM! Please, try again!" }
        }
    }
}
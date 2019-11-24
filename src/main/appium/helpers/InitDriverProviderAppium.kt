package main.appium.helpers

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

interface InitDriverProviderAppium {

    fun getAndroidDriver(): AppiumDriver<AndroidElement> {
        val androidCapabilities = DesiredCapabilities().apply {
            setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
            setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0")
            setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
            setCapability(MobileCapabilityType.APP, "/Users/romsper/Desktop/weather.apk") }
        return AndroidDriver(URL("http://0.0.0.0:4723/wd/hub"), androidCapabilities)
    }
}
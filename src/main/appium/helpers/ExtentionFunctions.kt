package main.appium.helpers

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import java.util.concurrent.TimeUnit

fun AndroidElement.pressKeyEnter(driver: AppiumDriver<*>) {
    kotlin.run { (driver as AndroidDriver<*>).pressKey(KeyEvent(AndroidKey.ENTER)) }
}

fun AppiumDriver<*>.wait(second: Long) {
    manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS)
}
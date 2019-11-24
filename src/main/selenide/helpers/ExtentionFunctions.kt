package main.selenide.helpers

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

fun SelenideElement.pressKeyEnter() {
    kotlin.run { (WebDriverRunner.getWebDriver() as AndroidDriver<*>).pressKey(KeyEvent(AndroidKey.ENTER)) }
}
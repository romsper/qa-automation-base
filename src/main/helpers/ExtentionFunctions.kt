package main.helpers

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner
import io.appium.java_client.AppiumDriver
import io.appium.java_client.PerformsTouchActions
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.interactions.Actions
import java.time.Duration


fun SelenideElement.pressKeyEnter() {
    (WebDriverRunner.getWebDriver() as AndroidDriver<*>).pressKey(KeyEvent(AndroidKey.ENTER))
}

fun appBackgroundAndLaunch(time: Long) {
    val driver = WebDriverRunner.getWebDriver() as AppiumDriver<*>
    driver.runAppInBackground(Duration.ofMillis(time))
    screen.login.authByDefaultCredentials()

//    val activity = WebDriverRunner.getWebDriver() as StartsActivity
//    activity.currentActivity()
}

fun appCloseAndStart(time: Long) {
    val driver = WebDriverRunner.getWebDriver() as AppiumDriver<*>
    driver.closeApp()
    Thread.sleep(time)
    driver.launchApp()
    screen.login.authByDefaultCredentials()
}

fun longTap_OLD(element: SelenideElement) {
    Actions(WebDriverRunner.getWebDriver()).clickAndHold(element).perform()
}

fun SelenideElement.moveToElement() {
    move(this)
}

fun move(element: SelenideElement) {
    PlatformTouchAction(WebDriverRunner.getWebDriver() as AppiumDriver<*>)
            .press(PointOption.point(element.location.getX(), element.location.getY() * 2))
            .moveTo(PointOption.point(element.location.getX(), element.location.getY()))
            .release()
            .perform()
}

fun SelenideElement.longTap() {
    longClick(this)
}

private fun longClick(element: SelenideElement) {
    PlatformTouchAction(WebDriverRunner.getWebDriver() as AppiumDriver<*>)
            .longPress(PointOption.point(element.location))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .release()
            .perform()
}

class PlatformTouchAction(performsActions: PerformsTouchActions): TouchAction<PlatformTouchAction>(performsActions)
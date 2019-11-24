package main.appium.activities

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import main.appium.helpers.InitDriverProviderAppium
import main.appium.helpers.pressKeyEnter
import org.openqa.selenium.support.PageFactory

class MainActivity(private val driver: AppiumDriver<*>) : InitDriverProviderAppium {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    @AndroidFindBy(id = "action_search")
    lateinit var btnSearch: AndroidElement

    @AndroidFindBy(id = "searchTextView")
    lateinit var inpSearch: AndroidElement

    fun chooseCity(city: String) {
        btnSearch.click()
        inpSearch.apply {
            sendKeys(city)
            pressKeyEnter(driver)
        }
    }


}
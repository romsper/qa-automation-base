package pages

import helpers.PlaywrightObject.page
import io.qameta.allure.Step

class VerifyAccountPage {
    private val inpCode get() = page?.locator("input[type='number']")?.all()
    private val txtMessage get() = page?.locator("small[class='info success']")

    fun open(): VerifyAccountPage {
        page?.navigate("${System.getProperty("TEST_HOST")}/apps/verify-account/")
        return this
    }

    @Step("Enter code: 999999")
    fun enterCode(): VerifyAccountPage {
        inpCode!!.forEach { it.fill("9") }
        return this
    }

    @Step("Press Enter")
    fun pressEnter(): VerifyAccountPage {
        page!!.keyboard().press("Enter")
        return this
    }

    @Step("Get Success message")
    fun getMessage(): String {
        return txtMessage!!.innerText()
    }
}
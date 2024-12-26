package helpers

import helpers.PlaywrightObject.browser
import helpers.PlaywrightObject.page
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

open class BaseTest {

    @BeforeEach
    fun openBrowser() {
        browser?.contexts()?.forEach { it.clearCookies() }
    }

    @AfterEach
    fun clearBrowser() {
    }

    companion object {

        @BeforeAll
        @JvmStatic
        fun initBrowser() {
            InitBrowser()
        }

        @AfterAll
        @JvmStatic
        fun closeBrowser() {
            browser!!.close()
            page!!.close()
        }
    }
}
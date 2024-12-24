package org.example.helpers

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright

class InitBrowser {

    init {
        try {
            val playwright = Playwright.create()
            val browser = when (System.getProperty("BROWSER_NAME", "chromium")) {
                "chromium" -> playwright.
                "firefox" -> playwright.firefox()
                "webkit" -> playwright.webkit()
                else -> throw RuntimeException("Wrong browser: ${System.getProperty("BROWSER_NAME")}")
            }
            browser.apply { launch(BrowserType.LaunchOptions()
                .setSlowMo(500.0)
                .setTimeout(30000.0)
                .setHeadless(false))
                .run {
                    PlaywrightObject.page = this.newPage()
                    PlaywrightObject.page?.navigate(System.getProperty("TEST_HOST", "https://google.com"))
                    PlaywrightObject.browser = this
                }
            }
        } catch (e: Exception) {
            throw RuntimeException("Failed to launch browser: ${e.message}")
        }
    }
}

object PlaywrightObject {
    var browser: Browser? = null
    var page: Page? = null
}



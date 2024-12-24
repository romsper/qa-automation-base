package org.example.helpers

import org.example.helpers.PlaywrightObject.browser
import org.example.helpers.PlaywrightObject.page
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

open class BaseTest {


    @BeforeEach
    fun openBrowser() {
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
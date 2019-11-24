package main.selenide.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.close
import com.codeborne.selenide.Selenide.open
import main.selenide.activities.MainActivity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


open class TestBase {
    val mainActivity = MainActivity()

    init {
        Configuration.browser = InitDriverProviderSelenide::class.java.name
    }

    @BeforeEach()
    fun initDriver() {
        close()
        open()
    }

    @AfterEach()
    fun closeDriver() {
        close()
    }
}
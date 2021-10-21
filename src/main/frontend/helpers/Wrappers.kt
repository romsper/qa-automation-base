package main.frontend.helpers

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class Wrappers {

    companion object {
        fun byDataTarget(target: String): By {
            return Selectors.by("data-target", target)
        }

        fun byDataTargetId(target: String): By {
            return Selectors.by("data-target-id", target)
        }
    }
}
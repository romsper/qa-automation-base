package frontend.helpers

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

fun element(bySelector: By) : SelenideElement {
    return `$`(bySelector)
}

fun element(selector: String) : SelenideElement {
    return `$`(selector)
}

fun elements(selector: String) : ElementsCollection {
    return `$$`(selector)
}

fun elements(bySelector: By) : ElementsCollection {
    return `$$`(bySelector)
}

fun byTarget(target : String) : By {
    return Selectors.by("data-target", target)
}

fun byTargetId(target : String) : By {
    return Selectors.by("data-target-id", target)
}
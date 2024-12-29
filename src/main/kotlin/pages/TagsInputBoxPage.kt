package pages

import com.microsoft.playwright.Locator
import helpers.PlaywrightObject.page
import io.qameta.allure.Step

class TagsInputBoxPage {
    private val inpText get() = page?.locator("input[type='text']")
    private val listTags get() = page?.locator("//li")?.all()
    private val txtCount get() = page?.locator("//div[@class='details']/p/span")
    private val btnRemoveAll get() = page?.locator("button")

    fun open(): TagsInputBoxPage {
        page?.navigate("${System.getProperty("TEST_HOST")}/apps/tags-input-box/")
        return this
    }

    @Step("Add Tag")
    fun addTag(tag: String): TagsInputBoxPage {
        inpText?.fill(tag)
        inpText?.press("Enter")
        return this
    }

    @Step("Get all Tags")
    fun getTags(): List<TagObject> {
        return listTags!!.map { Tag(it) }
            .map {
                TagObject(
                    text = it.name,
                    button = it.button
                )
            }
    }

    @Step("Get Tags Count")
    fun getTagsCount(): Int {
        return txtCount!!.innerText().toInt()
    }

    @Step("Remove All Tags")
    fun removeAllTags(): TagsInputBoxPage {
        btnRemoveAll!!.click()
        return this
    }
}

class Tag(item: Locator) {
    val name = item.innerText()
    val button = item.locator("xpath=.//i")
}

data class TagObject(
    val text: String,
    val button: Locator,
)
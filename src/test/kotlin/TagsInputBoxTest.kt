import helpers.BaseTest
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import pages.TagsInputBoxPage

class TagsInputBoxTest : BaseTest() {

    @Test
    fun checkAddTag() {
        val maxTagsCount = TagsInputBoxPage()
            .open()
            .removeAllTags()
            .getTagsCount()

        val addedTags = TagsInputBoxPage()
            .addTag("Tag1")
            .addTag("Tag2")
            .getTags()

        val tagsCount = TagsInputBoxPage().getTagsCount()

        addedTags.firstOrNull { it.text == "Tag1" }.shouldNotBeNull()
        addedTags.firstOrNull { it.text == "Tag2" }.shouldNotBeNull()
        (maxTagsCount - addedTags.size) shouldBe tagsCount
    }
}
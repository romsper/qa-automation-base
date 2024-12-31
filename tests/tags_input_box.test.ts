import { test, expect } from '@playwright/test'
import { TagsInputBoxPage } from '../pages/TagsInputBoxPage'

test.describe('Tags input box', () => {
    let tagsInputBoxPage: TagsInputBoxPage

    test.beforeEach(async ({ page }) => {
        tagsInputBoxPage = new TagsInputBoxPage(page)
    
        await tagsInputBoxPage.open()
      })

    test('Check add tags', async ({ page }) => {
        let maxTagsCount = await (await tagsInputBoxPage
            .removeAllTags())
            .getTagsCount()
        console.log(maxTagsCount)

        let addedTags = await (await (await tagsInputBoxPage
            .addTag("Tag1"))
            .addTag("Tag2"))
            .getTags()
        console.log(addedTags)

        let tagsCount = await tagsInputBoxPage.getTagsCount()
        console.log(tagsCount)

        expect(addedTags.find(tag => tag.text === "Tag1")).toBeDefined()
        expect(addedTags.find(tag => tag.text === "Tag2")).toBeDefined()
        expect(tagsCount).toBe(maxTagsCount - addedTags.length)
  })
})
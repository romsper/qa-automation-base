import { BasePage } from '../helpers/BasePage'

export class TagsInputBoxPage extends BasePage {
    inpText = this.page.locator("input[type='text']")
    listTags = this.page.locator("//li")
    txtCount = this.page.locator("//div[@class='details']/p/span")
    btnRemoveAll = this.page.locator("button")

    async open(): Promise<TagsInputBoxPage> {
        await this.page.goto("https://qaplayground.dev/apps/tags-input-box/")
        return this
    }

    async addTag(tag: string): Promise<TagsInputBoxPage> {
        await this.inpText.fill(tag)
        await this.inpText.press("Enter")
        return this
    }

    async getTagsCount(): Promise<number> {
        return await parseInt(await this.txtCount.innerText(), 10)
    }

    async removeAllTags(): Promise<TagsInputBoxPage> {
        await this.btnRemoveAll.click()
        return this
    }

    async getTags(): Promise<{ text: string, button: import("@playwright/test").Locator }[]> {
        return await Promise.all((await this.listTags.all()).map(async (tag) => {
            return { text: await tag.innerText(), button: await tag.locator(".//i") }
        }))
    }
    
}   

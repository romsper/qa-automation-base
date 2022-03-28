import { BasePage } from '../helpers/BasePage'

const inpQuery = "input[name='q']"

export class SearchPage extends BasePage {

    async openSearchPage() {
        await this.page.goto("https://google.com/")
        return this
    }

    async typeQuery(query: string) {
        await this.page.type(inpQuery, query)
        return this
    }

    async submitSearch() {
        await this.page.press(inpQuery, "Enter")
        return this
    }
}
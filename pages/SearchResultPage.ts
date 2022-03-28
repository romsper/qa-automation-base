import { BasePage } from "../helpers/BasePage"

const results = "div[class='g tF2Cxc']" //I know it's bad locator - don't worry ;) 

export class SearchResultPage extends BasePage {
    
    async getSearchList() {
        await this.waitSelector(results)
        return await this.page.$$(results)
    }
}


const results = "div[class='q']"

export class SearchResultPage {
    
    public getSearchList() {
        return page.$$(results)
    }
}

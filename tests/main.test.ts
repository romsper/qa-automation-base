import { test, expect } from '@playwright/test'
import { SearchPage } from '../pages/SearchPage'
import { SearchResultPage } from '../pages/SearchResultPage'

test.describe('Search test', () => {
    let search: SearchPage
    let searchResult: SearchResultPage

    test.beforeEach(async ({ page }) => {
        search = new SearchPage(page)
        searchResult = new SearchResultPage(page)
    
        await search.openSearchPage()
      })

    test('Verify search engine', async ({ page }) => {
        await (await search
            .typeQuery("Playwright"))
            .submitSearch()
        let results = await searchResult.getSearchList()
        expect(results.length).toBeGreaterThan(0)
  })
})
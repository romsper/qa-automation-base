import { registerAllureReporter } from "jest-allure/dist/setup";
import { Reporter } from 'jest-allure/dist/Reporter';

import { SearchPage } from '../pages/SearchPage'
import { SearchResultPage } from '../pages/SearchResultPage'
import { DashboardPage } from '../pages/DashboardPage';
import { AuthPage } from '../pages/AuthPage';

const search = new SearchPage
const searchResult = new SearchResultPage
const authPage = new AuthPage
const dashboardPage = new DashboardPage

jest.setTimeout(4 * 15000)

describe("Test Class Name", () => {

    test("Second", async () => {
        await page.goto("https://dev.domain.dev/");
        authPage.typeCredentials("email", "password")
        authPage.clickSignIn()
        const elemnts = await dashboardPage.elementsList()
        
        const name = await (await elemnts[2].getName())!!.innerText()
        const tag = await (await elemnts[1].getTag())!!.innerText()
        console.log("TAG: " + tag + "NAME: " + name)
        await page.waitForTimeout(15000)

//        await expect(page).toEqualText("h1", "Example Domain")
//        await expect(page).toHaveSelector('"Example Domain"', { state: "attached" })
    })
  })
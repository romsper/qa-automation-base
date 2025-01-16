import { BasePage } from '../helpers/BasePage'

export class MultiLevelDropdownPage extends BasePage {
    listNavItems = this.page.locator("li[class='nav-item']")
    listMenuItems = this.page.locator("a[class='menu-item']")

    async open(): Promise<MultiLevelDropdownPage> {
        await this.page.goto("https://qaplayground.dev/apps/multi-level-dropdown/")
        return this
    }
    
    async clickNavItem(id: number) {
        await this.listNavItems.nth(id).click()
        return this
    }

    async getMenuItems(): Promise<{ text: string, icon: import("@playwright/test").Locator }[]> {
        return await Promise.all((await this.listMenuItems.all()).map(async (item) => {
            return { link: await item.getAttribute("href"), text: await item.innerText(), icon: await item.locator("span[class='icon-button']") }
        }))
    }
    
}   

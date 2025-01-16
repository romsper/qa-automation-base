import { test, expect } from '@playwright/test'
import { MultiLevelDropdownPage } from '../pages/MultiLevelDropdownPage'

test.describe('Multi level dropdown', () => {
    let multiLevelDropdownPage: MultiLevelDropdownPage

    test.beforeEach(async ({ page }) => {
        multiLevelDropdownPage = new MultiLevelDropdownPage(page)
    
        await multiLevelDropdownPage.open()
      })

    test('Check sub menu', async ({ page }) => {
        let menuItems = await (await multiLevelDropdownPage
            .clickNavItem(3))
            .getMenuItems()
            
        
        await menuItems.find(item => item.text === "Settings")?.icon.click()
        let subMenuItems = await multiLevelDropdownPage.getMenuItems()

        subMenuItems = subMenuItems.filter(submenu => !menuItems.map(menu => menu.text).includes(submenu.text))
        
        expect(subMenuItems.length).toEqual(5)
  })
})
import { Page } from "@playwright/test"


export class BasePage {
  readonly page: Page

  constructor(page: Page) {
    this.page = page
  }

  async wait(time) {
    await this.page.waitForTimeout(time)
  }

  async waitSelector(selector) {
    await this.page.waitForSelector(selector)
  }
}
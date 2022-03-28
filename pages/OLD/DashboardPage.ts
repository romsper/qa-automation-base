// import { SelectorType } from "jest-playwright-preset"
// import { ListOfElements } from "./ListOfElements"

// const cardWrapper = "div[class='cardWrapper']"
// const listElements = "div[class='container']"
// const tagName = "h4[class='title']"

// export class DashboardPage {

//     public async elementsList() {
//         await page.waitForSelector(cardWrapper)
//         const cards = await  page.$$(listElements)
//         return cards.map(item => new ListOfElements(item))
//     }

//     public async printFirstCard() {
//         await page.waitForSelector(cardWrapper)
//         const cardBlock = await page.$(cardWrapper)
//         const cardList = await cardBlock!!.$$(listElements)
//         const firstCard = cardList[0]
//         const firstCardTag = await firstCard.$(tagName)
//         const text = await firstCardTag?.innerText()
//         return text
//     }
// }
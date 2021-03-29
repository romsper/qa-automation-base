import { ElementHandle } from 'playwright'

const listElements = "div[class='container']"
const itemName = "h4[class='title']"
const itemTag = "div[class='tag-wrapper']"

export class ListOfElements {
    private list!: ElementHandle<SVGElement | HTMLElement>

    constructor(list: ElementHandle<SVGElement | HTMLElement>) {
        this.list = list
    }

    public async getName() {
        return await this.list.$(itemName)
    }

    public async getTag() {
        return await this.list.$(itemTag)
    }
}
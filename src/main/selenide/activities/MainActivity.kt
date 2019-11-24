package main.selenide.activities

import com.codeborne.selenide.ElementsContainer
import main.selenide.elements.IMainActivityElem

class MainActivity: ElementsContainer(), IMainActivityElem {

    override fun searchCityByName(city: String) {
        super.searchCityByName(city)
    }
}
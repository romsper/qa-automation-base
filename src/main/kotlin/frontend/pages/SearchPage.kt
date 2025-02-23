package org.example.pages.simpleWine

import io.qameta.allure.Step
import org.example.elements.simpleWine.list.ProductItemHelper
import org.example.elements.simpleWine.list.CatalogItemObject

class SearchPage {
    private val productItemHelper get() = ProductItemHelper()

    @Step("Get product items")
    fun getProductItems(): List<CatalogItemObject> {
        return productItemHelper.getProductItems()
    }

}
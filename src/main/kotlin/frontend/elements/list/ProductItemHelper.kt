package org.example.elements.simpleWine.list

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTarget

class ProductItemHelper {
    private val listCatalogItems get() = elements(byDataTarget("product-item"))

    fun getProductItemOLD(): List<CatalogItemObject> {
        listCatalogItems.first().scrollTo()
        listCatalogItems.first().shouldBe(Condition.visible)

        return listCatalogItems
            .map { CatalogItem(it) }
            .map {
                CatalogItemObject(
                    articul = it.articul.text,
                    image = it.image,
                    name = it.name.text,
                    price = it.price.text.filter { it.isDigit() }.toInt(),
                    btnAddToCart = it.btnAddToCart,
                )
            }
    }

    fun getProductItems(): List<CatalogItemObject> {
        listCatalogItems.first().scrollTo()
        listCatalogItems.first().shouldBe(Condition.visible)

        return listCatalogItems
            .map {
                CatalogItemObject(
                    articul = it.find(byDataTarget("product-item-article")).text,
                    image = it.find(byDataTarget("product-item-big-image")),
                    name = it.find(byDataTarget("product-item-name")).text,
                    price = it.find(byDataTarget("product-item-final-price")).text.filter { it.isDigit() }.toInt(),
                    btnAddToCart = it.find(byDataTarget("product-item-cart-btn")),
                )
            }
    }
}

class CatalogItem(item: SelenideElement) {
    val articul = item.find("div[data-autotest-target=product-item-article]")
    val image = item.find("a[data-autotest-target=product-item-big-image]")
    val name = item.find("a[data-autotest-target=product-item-name]")
    val price = item.find("div[data-autotest-target=product-item-final-price]")
    val btnAddToCart = item.find("div[data-autotest-target=product-item-cart-btn]")
}

data class CatalogItemObject(
    val articul: String,
    val image: SelenideElement,
    val name: String,
    val price: Int,
    val btnAddToCart: SelenideElement,
)
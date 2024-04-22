package frontend.elements

// An example of how to work with multiple elements on the page
// Might be goods, messages, users, etc.

//class ProductHelper {
//    private val PRODUCT_LIST get() = elements(byDataTarget("product-item"))
//
//    private fun convertListToObject(): List<ProductItemModel> {
//        PRODUCT_LIST.first().scrollTo()
//        PRODUCT_LIST.first().shouldBe(Condition.appear)
//        return PRODUCT_LIST.map { ProductItem(it) }
//            .map { ProductItemModel(
//                artNumber = it.PRODUCT_ART.text,
//                btnFavorite = it.PRODUCT_FAVORITE_BTN,
//                name = it.PRODUCT_NAME.text,
//                discount = it.PRODUCT_DISCOUNT.text,
//                price = it.PRODUCT_PRICE.text.filter { str -> str.isDigit() }.toInt(),
//                btnAddToCart = it.PRODUCT_ADD_BTN,
//            ) }
//    }

//    @Step("Взять список продуктов как обьекты")
//    fun getProductList(): List<ProductItemModel> {
//        return convertListToObject()
//    }
//}
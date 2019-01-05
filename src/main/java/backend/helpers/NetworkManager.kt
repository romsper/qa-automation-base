package backend.helpers

import io.qameta.allure.Step
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured.given
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

class NetworkManager {
    val spec = Specs()

    @Step("Execute POST and extract body as object")
    fun <T> extractPost(spec: RequestSpecification, responseClass: Class<T>, requestBody: Any): T {
        return given()
                .spec(spec)
                .filter(AllureRestAssured())
                .body(requestBody)
                .post()
                .then()
                .extract().`as`(responseClass)
    }

    @Step("Execute GET and extract body as object")
    fun <T> extractGet(url: String, responseClass: Class<T>?): T {
        return given()
                .spec(spec.specDefault(url))
                .`when`()
                .filter(AllureRestAssured())
                .urlEncodingEnabled(false)
                .get()
                .then()
                .extract().`as`(responseClass)
    }

    @Step("Execute PATCH and extract body as object")
    fun <T> executePatch(url: String, requestBody: Any, responseClass: Class<T>): T {
        return given()
                .`when`()
                .body(requestBody)
                .urlEncodingEnabled(false)
                .patch(url)
                .then()
                .extract().`as`(responseClass)
    }

    @Step("Execute GET")
    fun executeGet(url: String): Response {
        return given()
                .spec(spec.specDefault(url))
                .`when`()
                .filter(AllureRestAssured())
                .urlEncodingEnabled(false)
                .get()
                .then()
                .extract()
                .response()
    }

    @Step("Execute POST")
    fun executePost(spec: RequestSpecification?, url: String?, requestBody: Any): Response {
        return given()
                .spec(spec)
                .body(requestBody)
                .post(url)
                .then()
                .extract()
                .response()
    }
}
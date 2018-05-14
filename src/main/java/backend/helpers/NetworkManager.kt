package main.java.backend.helpers

import io.qameta.allure.Step
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured.given
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

class NetworkManager {
    companion object {
        val ENDPOINT_URL =
                if (System.getProperty("API_URL").isNullOrEmpty()) "https://randomuser.me/api"
                else System.getProperty("API_URL")
    }

    @Step("Выполнение POST запроса и извлечение ответа как Класс")
    fun <T> extractPost(spec: RequestSpecification, responseClass: Class<T>, requestBody: Any): T {
        return given()
                .spec(spec)
                .filter(AllureRestAssured())
                .body(requestBody)
                .post()
                .then()
                .extract().`as`(responseClass)
    }

    @Step("Выполнение GET запроса и извлечение ответа как Класс")
    fun <T> extractGet(url: String?, responseClass: Class<T>?): T {
        return given()
                .`when`()
                .filter(AllureRestAssured())
                .urlEncodingEnabled(false)
                .get(url)
                .then()
                .extract().`as`(responseClass)
    }

    @Step("Выполнение PATCH запроса и извлечение ответа как Класс")
    fun <T> executePatch(url: String, requestBody: Any, responseClass: Class<T>): T {
        return given()
                .`when`()
                .body(requestBody)
                .urlEncodingEnabled(false)
                .patch(url)
                .then()
                .extract().`as`(responseClass)
    }

    @Step("Выполнение GET запроса")
    fun executeGet(url: String): Response {
        return given()
                .`when`()
                .filter(AllureRestAssured())
                .urlEncodingEnabled(false)
                .get(url)
                .then()
                .extract()
                .response()
    }

    @Step("Выполнение POST запроса")
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
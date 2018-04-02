package main.java.backend.helpers

import io.qameta.allure.Step
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured.given
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

class NetworkManager {
    companion object {
        val host = System.getProperty("HOST")
        val protocol = System.getProperty("PROTOCOL")
        val apiVersion = System.getProperty("API_VERSION")

        val apiUrl = "${protocol}${host}${apiVersion}"

        @Step("Выполнение POST запроса")
        fun <T> responsePost(spec: RequestSpecification, responseClass: Class<T>, requestBody: Any): T {
            return given()
                    .spec(spec)
                    .filter(AllureRestAssured())
                    .body(requestBody)
                    .post()
                    .then()
                    .extract().`as`(responseClass)
        }

        @Step("Выполнение GET запроса")
        fun <T> responseGet(url: String?, responseClass: Class<T>?): T {
            return given()
                    .`when`()
                    .filter(AllureRestAssured())
                    .urlEncodingEnabled(false)
                    .get(url)
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

        @Step("Выполнение PATCH запроса")
        fun <T> executePatchCallTracking(url: String, requestBody: Any, responseClass: Class<T>): T {
            return given()
                    .`when`()
                    .body(requestBody)
                    .urlEncodingEnabled(false)
                    .patch(url)
                    .then()
                    .extract().`as`(responseClass)
        }
    }
}
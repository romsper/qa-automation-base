package backend.helpers

import io.qameta.allure.Step
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import main.java.backend.helpers.NetworkManager.Companion.ENDPOINT_URL

class Specs {

    @Step("SPEC without Token")
    fun specDefault(hand: String): RequestSpecification? {
        return RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri("$ENDPOINT_URL$hand")
                .build()
    }

    @Step("SPEC with Token")
    fun specToken(hand: String): RequestSpecification {
        return RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri("$ENDPOINT_URL$hand")
                .addHeader("Authorization", "Bearer TOKEN")
                .build()
    }
}
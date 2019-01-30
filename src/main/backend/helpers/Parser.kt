package main.backend.helpers

import com.google.gson.Gson
import io.qameta.allure.Step
import java.util.concurrent.TimeUnit

class Parser {
    fun <T> jsonToObject(body: String, obj: Class<T>): T {
        return Gson().fromJson<T>(body, obj) }

    @Step("Convert JSON to Object")
    inline fun <reified T> jsonToObject(body: String) = jsonToObject(body, T::class.java)

    @Step("Wait")
    fun wait(seconds: Long?) = TimeUnit.SECONDS.sleep(seconds!!)
}
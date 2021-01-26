package main.backend.extention

import com.google.gson.Gson
import io.kotest.assertions.fail
import io.qameta.allure.Step
import retrofit2.Call
import retrofit2.Response

class Functions {

    companion object {

        @Step("Cast request body to model")
        inline fun <reified T> Response<T>.getAsObject(): T {
            return body()!! }

        inline fun <reified T> Response<T>.getErrorBody(): String {
            return errorBody()!!.string() }

        @Step("Convert JSON to Object")
        fun <T> String.jsonToObject(obj: Class<T>): T {
            return Gson().fromJson(this, obj)
        }

        inline fun <reified T> Call<T>.retryIfEmpty(count: Int): Response<T> {
            var i = 1
            var res: Response<T>
            do {
                res = this.clone().execute()
                if ((res.getAsObject() as List<*>).isNotEmpty()) break
                if (i == count) fail("Request body is empty") else i++
            } while ((res.getAsObject() as List<*>).isEmpty())
            return res
        }
    }
}
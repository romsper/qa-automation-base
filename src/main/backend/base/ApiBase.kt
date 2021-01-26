package main.backend.base

import main.backend.api.UserApi
import main.backend.helpers.RetrofitClient

open class ApiBase {

    val userApi by lazy { RetrofitClient.createService(UserApi::class.java) }
}
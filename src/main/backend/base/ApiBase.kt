package backend.base

import backend.api.UserApi
import backend.helpers.RetrofitClient

open class ApiBase {

    val userApi by lazy { RetrofitClient.createService(UserApi::class.java) }
}
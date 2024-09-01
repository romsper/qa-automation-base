package backend.base

import backend.api.AuthApi
import backend.api.UserApi
import backend.helpers.RetrofitClient

interface ApiBase {
    val authApi get() = RetrofitClient.createService(AuthApi::class.java)
    val userApi get() = RetrofitClient.createService(UserApi::class.java)
}
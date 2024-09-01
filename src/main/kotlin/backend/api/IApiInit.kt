package backend.api

import backend.helpers.RetrofitClient

interface IApiInit {
    val authApi get() = RetrofitClient.createService(AuthApi::class.java)
    val userApi get() = RetrofitClient.createService(UserApi::class.java)
}
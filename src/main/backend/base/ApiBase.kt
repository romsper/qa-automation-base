package main.backend.base

import main.backend.api.UserApi
import main.backend.helpers.Retrofit
import retrofit2.create

open class ApiBase : Retrofit() {

    val userApi = retrofit().create<UserApi>()
}
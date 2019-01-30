package main.backend.api

import main.backend.pojo.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {

    @GET("api/")
    fun getUsers(): Call<UserResponse>
}
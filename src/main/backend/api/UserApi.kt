package backend.api

import backend.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {

    @GET("api/")
    fun getUsers(): Call<UserResponse>
}
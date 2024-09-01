package backend.api

import backend.models.AuthResponseModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap

interface AuthApi {

    @Multipart
    @POST("ajax/auth/by-email/")
    fun postAuthorization(
        @PartMap body: MutableMap<String, RequestBody> = mutableMapOf()
    ): Call<AuthResponseModel>

}
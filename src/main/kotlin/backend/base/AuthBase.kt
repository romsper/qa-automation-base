package backend.base

import backend.models.AuthRequestModel
import backend.models.AuthResponseModel
import io.qameta.allure.Step
import retrofit2.Response

class AuthBase: ApiBase {

    @Step("Authorization: {email} | {password}")
    fun authorization(email: String, password: String): Response<AuthResponseModel> {
        val body = AuthRequestModel(email = email, password = password).toMap()
        return authApi.postAuthorization(body = body).execute()
    }
}
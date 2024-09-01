package backend.base

import backend.api.IApiInit
import io.qameta.allure.Step

class UserBaseI: IApiInit {

    @Step("Get users")
    fun getUsers() = userApi.getUsers().execute()
}
package main.backend.base

import io.qameta.allure.Step
import main.backend.base.ApiBase

class UserBase : ApiBase() {

    @Step("Get users")
    fun getUsers() = userApi.getUsers().execute()
}
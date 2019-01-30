package test.backend

import io.qameta.allure.Feature
import io.qameta.allure.Story
import main.backend.base.TestBase
import main.backend.helpers.getAsObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@Feature("User")
@Story("getUsers")
@Tags(Tag("user"), Tag("regress"))
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest : TestBase() {

    @Test
    fun checkUser() {
        val user = userBase.getUsers().getAsObject()

        assertThat(user.results!!.first()!!.id).isNotNull
    }
}
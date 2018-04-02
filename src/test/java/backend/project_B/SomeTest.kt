package test.java.backend.project_B

import main.java.backend.helpers.EndpointsGet
import main.java.backend.helpers.NetworkManager.Companion.executeGet
import main.java.backend.helpers.NetworkManager.Companion.responseGet
import backend.project_B.scheme.SeedExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("api")
class SomeTest {

    @Test
    @DisplayName("Get one user")
    fun checkUserName() {
        val user = executeGet(EndpointsGet.NEW.hand).body.asString()
        assertThat(user).contains("name")
    }

    @Test
    @DisplayName("Check seed")
    fun checkSeed() {
        val seed = responseGet(url = EndpointsGet.SEED.hand, responseClass = SeedExample::class.java)
        assertThat(seed.results[0].name.first).isEqualTo("becky")
    }


}
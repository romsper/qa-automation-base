package test.java.backend.project_B

import backend.helpers.Endpoints
import main.java.backend.helpers.NetworkManager.Companion.executeGet
import main.java.backend.helpers.NetworkManager.Companion.responseGet
import backend.scheme.SeedExample
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

@Test(groups = ["api"])
class SomeTest {

    @Test(testName = "Get one user")
    fun checkUserName() {
        val user = executeGet(Endpoints.NEW.hand).body.asString()
        assertThat(user).contains("name")
    }

    @Test(testName = "Check seed")
    fun checkSeed() {
        val seed = responseGet(url = Endpoints.SEED.hand, responseClass = SeedExample::class.java)
        assertThat(seed.results[0].name.first).isEqualTo("becky")
    }
}
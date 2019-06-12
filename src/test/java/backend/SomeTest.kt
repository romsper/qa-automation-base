package backend

import backend.base.TestBase
import backend.helpers.Endpoints

import backend.scheme.SeedExample
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.Test

@Test(groups = ["api"])
class SomeTest : TestBase() {

    @Test(testName = "Get one user")
    fun checkUserName() {
        val user = network.executeGet(Endpoints.NEW.hand).body.asString()

        assertThat(user).contains("name")
    }

    @Test(testName = "Check seed")
    fun checkSeed() {
        val seed = network.extractGet(url = Endpoints.SEED.hand, responseClass = SeedExample::class.java)

        assertThat(seed.results.get(0).name.first).isEqualTo("becky")
    }
}
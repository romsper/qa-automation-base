package backend.project_B.scheme
import com.fasterxml.jackson.annotation.JsonProperty



data class SeedExample(
		@JsonProperty("results") val results: List<Result>,
		@JsonProperty("info") val info: Info
)

data class Info(
		@JsonProperty("seed") val seed: String, //foobar
		@JsonProperty("results") val results: Int, //1
		@JsonProperty("page") val page: Int, //1
		@JsonProperty("version") val version: String //1.1
)

data class Result(
		@JsonProperty("gender") val gender: String, //female
		@JsonProperty("name") val name: Name,
		@JsonProperty("location") val location: Location,
		@JsonProperty("email") val email: String, //becky.sims@example.com
		@JsonProperty("login") val login: Login,
		@JsonProperty("dob") val dob: String, //1991-03-17 09:11:50
		@JsonProperty("registered") val registered: String, //2014-04-06 03:47:45
		@JsonProperty("phone") val phone: String, //017684 66711
		@JsonProperty("cell") val cell: String, //0765-055-205
		@JsonProperty("id") val id: Id,
		@JsonProperty("picture") val picture: Picture,
		@JsonProperty("nat") val nat: String //GB
)

data class Name(
		@JsonProperty("title") val title: String, //miss
		@JsonProperty("first") val first: String, //becky
		@JsonProperty("last") val last: String //sims
)

data class Id(
		@JsonProperty("name") val name: String, //NINO
		@JsonProperty("value") val value: String //PA 88 25 20 D
)

data class Location(
		@JsonProperty("street") val street: String, //6894 windsor road
		@JsonProperty("city") val city: String, //stirling
		@JsonProperty("state") val state: String, //durham
		@JsonProperty("postcode") val postcode: String //Q4 8YT
)

data class Login(
		@JsonProperty("username") val username: String, //brownduck326
		@JsonProperty("password") val password: String, //missouri
		@JsonProperty("salt") val salt: String, //NuJHyJ9Z
		@JsonProperty("md5") val md5: String, //10be07f2d1052f6fc04b1788e31d5e3b
		@JsonProperty("sha1") val sha1: String, //f28ca2d01b49c3011e6beba774414af8521d0d75
		@JsonProperty("sha256") val sha256: String //70c3460949945b3912ec3903da43d1cacaa2c2aa3770668f4ab07a602c2e3ccb
)

data class Picture(
		@JsonProperty("large") val large: String, //https://randomuser.me/api/portraits/women/67.jpg
		@JsonProperty("medium") val medium: String, //https://randomuser.me/api/portraits/med/women/67.jpg
		@JsonProperty("thumbnail") val thumbnail: String //https://randomuser.me/api/portraits/thumb/women/67.jpg
)
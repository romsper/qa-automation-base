package main.backend.pojo
import com.google.gson.annotations.SerializedName


data class UserResponse(
        @SerializedName("info")
    var info: Info?,
        @SerializedName("results")
    var results: List<Result?>?
)

data class Info(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var results: Int?,
    @SerializedName("seed")
    var seed: String?,
    @SerializedName("version")
    var version: String?
)

data class Result(
        @SerializedName("cell")
    var cell: String?,
        @SerializedName("dob")
    var dob: Dob?,
        @SerializedName("email")
    var email: String?,
        @SerializedName("gender")
    var gender: String?,
        @SerializedName("id")
    var id: Id?,
        @SerializedName("location")
    var location: Location?,
        @SerializedName("login")
    var login: Login?,
        @SerializedName("name")
    var name: Name?,
        @SerializedName("nat")
    var nat: String?,
        @SerializedName("phone")
    var phone: String?,
        @SerializedName("picture")
    var picture: Picture?,
        @SerializedName("registered")
    var registered: Registered?
)

data class Location(
        @SerializedName("city")
    var city: String?,
        @SerializedName("coordinates")
    var coordinates: Coordinates?,
        @SerializedName("postcode")
    var postcode: String?,
        @SerializedName("state")
    var state: String?,
        @SerializedName("street")
    var street: String?,
        @SerializedName("timezone")
    var timezone: Timezone?
)

data class Coordinates(
    @SerializedName("latitude")
    var latitude: String?,
    @SerializedName("longitude")
    var longitude: String?
)

data class Timezone(
    @SerializedName("description")
    var description: String?,
    @SerializedName("offset")
    var offset: String?
)

data class Picture(
    @SerializedName("large")
    var large: String?,
    @SerializedName("medium")
    var medium: String?,
    @SerializedName("thumbnail")
    var thumbnail: String?
)

data class Name(
    @SerializedName("first")
    var first: String?,
    @SerializedName("last")
    var last: String?,
    @SerializedName("title")
    var title: String?
)

data class Login(
    @SerializedName("md5")
    var md5: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("salt")
    var salt: String?,
    @SerializedName("sha1")
    var sha1: String?,
    @SerializedName("sha256")
    var sha256: String?,
    @SerializedName("username")
    var username: String?,
    @SerializedName("uuid")
    var uuid: String?
)

data class Registered(
    @SerializedName("age")
    var age: Int?,
    @SerializedName("date")
    var date: String?
)

data class Id(
    @SerializedName("name")
    var name: String?,
    @SerializedName("value")
    var value: String?
)

data class Dob(
    @SerializedName("age")
    var age: Int?,
    @SerializedName("date")
    var date: String?
)
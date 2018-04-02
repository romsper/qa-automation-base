package main.java.backend.helpers

enum class EndpointsGet(val hand: String) {
    NEW("https://randomuser.me/api/1.1/"),
    SEED("https://randomuser.me/api/?seed=foobar")
}
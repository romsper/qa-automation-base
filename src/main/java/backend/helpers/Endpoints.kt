package backend.helpers

enum class Endpoints(val hand: String) {
    NEW("/1.1/"),
    SEED("/?seed=foobar")
}
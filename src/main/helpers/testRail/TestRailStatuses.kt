package main.helpers.testRail

enum class TestRailStatuses(val id: Int) {
    PASSED(1),
    BLOCKED(2),
    UNTESTED(3),
    RETEST(4),
    FAILED(5)
}
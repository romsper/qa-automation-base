package listeners

import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import org.slf4j.LoggerFactory

open class EventListener : ITestListener {

    override fun onTestStart(result: ITestResult) {
        println("Start: " + result.name)
    }

    override fun onTestSkipped(result: ITestResult) {
        println("Skipped: " + result.name)
    }

    override fun onTestSuccess(result: ITestResult) {
        println("Success: " + result.name)
    }

    override fun onTestFailure(result: ITestResult) {
        println("Failure: " + result.name)
    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult) {
        println("Broken: " + result.name)
    }

    override fun onStart(result: ITestContext?) {
        println("-------------- START --------------")
    }

    override fun onFinish(context: ITestContext?) {
        println("-------------- FINISH --------------")
    }
}
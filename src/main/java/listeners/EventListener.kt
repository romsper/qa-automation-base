package main.java.listeners

import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult
import org.slf4j.LoggerFactory

open class EventListener : ITestListener {
    val logger = LoggerFactory.getLogger(EventListener::class.java)

    override fun onTestStart(result: ITestResult?) {
        logger.info("Start test " + result!!.name)
    }

    override fun onFinish(context: ITestContext?) {
        logger.info("Stop test " + context!!.name)
    }

    override fun onTestSkipped(result: ITestResult) {
        logger.info("Skip test " + result!!.name)
    }

    override fun onTestSuccess(result: ITestResult) {
        logger.info("Success test " + result!!.name)
    }

    override fun onTestFailure(result: ITestResult) {
        logger.info("Failure test " + result!!.name)
    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult) {
    }

    override fun onStart(result: ITestContext?) {
    }
}
package listeners

import org.testng.IRetryAnalyzer
import org.testng.ITestResult

class RetryAnalyzer : IRetryAnalyzer {

    var counter = 0
    val retryLimit = 1

    override fun retry(result: ITestResult?): Boolean {
        if (counter < retryLimit) {
            counter++
            return true
        }
        return false
    }
}
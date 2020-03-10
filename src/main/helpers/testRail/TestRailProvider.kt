package main.helpers.testRail

import com.codepine.api.testrail.model.Result
import main.helpers.testRail.TestRailReport.addResult
import main.helpers.testRail.TestRailReport.reportResults
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ExtensionContext.Store.CloseableResource
import org.junit.jupiter.api.extension.TestWatcher
import java.util.*

class TestRailIdProvider : TestWatcher, BeforeAllCallback {
    override fun testDisabled(extensionContext: ExtensionContext, optional: Optional<String>) {
        addResult(extensionContext, TestRailStatuses.UNTESTED)
    }

    override fun testSuccessful(extensionContext: ExtensionContext) {
        addResult(extensionContext, TestRailStatuses.PASSED)
    }

    override fun testAborted(extensionContext: ExtensionContext, throwable: Throwable) {
        addResult(extensionContext, TestRailStatuses.RETEST)
    }

    override fun testFailed(extensionContext: ExtensionContext, throwable: Throwable) {
        addResult(extensionContext, TestRailStatuses.FAILED)
    }

    @Throws(Exception::class)
    override fun beforeAll(extensionContext: ExtensionContext) {
        if (!started) {
            getStore(extensionContext).put(TESTRAIL_REPORT, CloseableOnlyOnceResource())
            started = true
        }
    }

    private class CloseableOnlyOnceResource : CloseableResource {
        override fun close() {
            reportResults()
        }
    }

    private fun addResult(extensionContext: ExtensionContext, status: TestRailStatuses) {
        if (extensionContext.element.isPresent && extensionContext.element.get().isAnnotationPresent(
                        TestRail::class.java)) {
            val element = extensionContext.element.get().getAnnotation(TestRail::class.java)
            val result = Result().setTestId(element.id.toInt()).setStatusId(status.id)
                    .setCaseId(element.id.toInt())
            addResult(result)
        }
    }

    private fun getStore(context: ExtensionContext): ExtensionContext.Store {
        return context.root.getStore(ExtensionContext.Namespace.GLOBAL)
    }

    companion object {
        private var started = false
        private const val TESTRAIL_REPORT = "TEST_RAIL"
    }
}
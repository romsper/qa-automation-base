package general.listeners

import com.codeborne.selenide.Screenshots
import io.qameta.allure.Attachment
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.TestIdentifier
import org.junit.platform.launcher.TestPlan

class TestListener : TestExecutionListener {

    override fun testPlanExecutionStarted(testPlan: TestPlan?) {
        println("|----- START -----|\n")
    }

    override fun executionFinished(testIdentifier: TestIdentifier?, testExecutionResult: TestExecutionResult?) {
        if (testIdentifier!!.isTest) println("Finish: ${testIdentifier.displayName}")
        if (testExecutionResult!!.status == TestExecutionResult.Status.FAILED && testIdentifier.displayName != "JUnit Jupiter") {
            attachScreenshot()
        }
    }

    override fun executionSkipped(testIdentifier: TestIdentifier?, reason: String?) {
        if (testIdentifier!!.isTest) println("Skip: ${testIdentifier.displayName}\nReason: $reason")
    }

    override fun testPlanExecutionFinished(testPlan: TestPlan?) {
        println("|----- FINISH -----|")
    }

    @Attachment(value = "{name}", type = "image/png")
    fun attachScreenshot(name: String = "SCREENSHOT"): ByteArray? {
        return Screenshots.takeScreenShotAsFile()?.readBytes()
    }
}

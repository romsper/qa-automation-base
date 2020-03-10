package main.listeners

import com.codeborne.selenide.Driver
import com.codeborne.selenide.SelenideDriver
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Attachment
import main.helpers.TestBase
import main.helpers.testRail.TestRail
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.TestIdentifier
import org.junit.platform.launcher.TestPlan

class TestListener : TestExecutionListener {

    override fun testPlanExecutionStarted(testPlan: TestPlan?) {
        println("|----- START -----|\n")
    }

    override fun executionFinished(testIdentifier: TestIdentifier?, testExecutionResult: TestExecutionResult?) {
        if (testIdentifier!!.isTest) println("${testExecutionResult!!.status}: ${testIdentifier.displayName}")
    }

    override fun executionSkipped(testIdentifier: TestIdentifier?, reason: String?) {
        if (testIdentifier!!.isTest) println("Skip: ${testIdentifier.displayName}\nReason: $reason")
    }

    override fun testPlanExecutionFinished(testPlan: TestPlan?) {
        println("|----- FINISH -----|")
    }
}
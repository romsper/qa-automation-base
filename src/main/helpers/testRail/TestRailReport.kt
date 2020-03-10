package main.helpers.testRail

import com.codepine.api.testrail.TestRail
import com.codepine.api.testrail.model.Result
import com.codepine.api.testrail.model.Run
import main.helpers.InitDriverProvider
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.stream.Collectors

object TestRailReport {
    private val results: MutableList<Result> = ArrayList()

    fun addResult(result: Result) {
        results.add(result)
    }

    fun reportResults() {
        val properties = loadProperties()
        val host = properties.getProperty("testrail_host").trim()
        val user = properties.getProperty("testrail_user").trim()
        val password = properties.getProperty("testrail_password").trim()
        val projectId = properties.getProperty("testrail_projectId").trim()
        val suiteId = properties.getProperty("testrail_suiteId").trim().toInt()
        val testRail = TestRail.builder(host, user, password).build()
        val project = testRail.projects()[projectId.toInt()].execute()

        val dateTime = LocalDateTime.now()
        val prettyDateTime = dateTime.format(DateTimeFormatter.ofPattern("M/d/y H:m:ss"))

        val run = testRail.runs()
                .add(project.id,
                        Run().setName("${InitDriverProvider().platform} | ${InitDriverProvider().device_name} (${InitDriverProvider().jenkins_os_version}) | $prettyDateTime")
                                .setIncludeAll(false)
                                .setSuiteId(suiteId)
                                .setCaseIds(results.map { k: Result -> k.caseId }))
                .execute()
        val customResultFields = testRail.resultFields().list().execute()
        testRail.results().addForCases(run.id, results, customResultFields).execute()
        //We can't delete closed runs from TestRail
//        testRail.runs().close(run.id).execute()
    }

    fun loadProperties(): Properties {
        val env = Optional.ofNullable(System.getProperty("env")).orElse("testrail")
        val properties = Properties()
        val props = ClassLoader::class.java.getResourceAsStream("/$env.properties")
        properties.load(props)
        return properties
    }
}
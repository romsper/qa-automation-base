# Automation project

#### Description

There are basic projects for automation frameworks based on **Kotlin/Java** and **TypeScript** for the **backend**, **frontend**, and **mobile**.

#### GitHub Actions

This branch `kotlin-junit5-retrofit` is integrated with GHA -> I pass test results to this branch `allure-pages` and host them using GitHub Pages 

#### Branches

  - [kotlin-testng-rest-assured](https://github.com/romsper/qa-automation-bases/tree/kotlin-testng-rest-assured) - Kotlin | Rest-Assured | Selenide | TestNG | Allure
  - [kotlin-junit5-retrofit](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-retrofit) - Kotlin | Retrofit | Selenide | JUnit 5 | Allure -> Updated `26.01.2021`
  - [kotlin-junit5-appium](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-appium) - Kotlin | Selenide/Appium | JUnit 5 | Allure | Allure EE | TestRail
  - [kotlin-gradle-allure](https://github.com/romsper/qa-automation-bases/tree/kotlin-gradle-allure) - Kotlin | Gradle | JUnit 5 | Allure `27.08.2021`
  - [js-mocha-chai](https://github.com/romsper/qa-automation-bases/tree/js-mocha-chai) - JS | Mocha | Chai | Allure
  - [typescript-playwright-allure](https://github.com/romsper/qa-automation-bases/tree/typescript-playwright-allure) - TypeScript | Playwright | Allure -> Updated `28.03.2022`
  
#### Frameworks 

[Kotlin](https://kotlinlang.org/docs/reference/) - programming language based on JVM and fully compatible with Java! It's much easier than Java don't worry ;) 

[JUnit5](https://junit.org/junit5/docs/current/user-guide/) - highly recommend reading about [DataProviders](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources) aka Sources

[Selenide](https://selenide.org/) - framework for test automation powered by Selenium WebDriver.

[Selenoid](https://aerokube.com/selenoid/latest/) - powerful `Golang` implementation of the original Selenium Grid farm. One configuration for the `localhost` and `remote` runs and easy to update and manage through `Docker` and `VNC` `(free)`. Also, they provide `paid` `Kubernetes` (`free` for 4 pods) solution [Moon](https://aerokube.com/)

[Retrofit](https://square.github.io/retrofit/) - this is the framework for work with API. It's much faster and easier than Rest-Assured. Also, it provides a better code style.

[Kotest](https://github.com/kotest/kotest) - highly recommend using this framework as a main assertion framework for your projects. If you prefer java - [AssertJ](https://assertj.github.io/doc/) 


# Report

[Allure](https://docs.qameta.io/allure/) - the best test report framework ever! This framework supports the most popular languages and test runners, easy to integrate to the almost any CI. Also, we can integrate our reports with Grafana and show some graphics like Duration | Passed | Failed and etc.

#### The most popular annotation: 

`@Step` - combine all steps (annotated methods) and generate a readable test report where you will see all the steps as text. Also, it adds variables with values to the step into the report.

`@DisplayName` - just JUnit 5 annotation witch means a test name

`@Issue` - add a link to Jira (or any other system) into your report for the test

`@TmsLink` - add a link to TestRail (or any other system) into your report for the test

`@Severity` - add a marker as BLOCKER or CRITICAL and etc into your report for the test

`@Flaky` - add a marker the test as flaky in the report system

`@Epic` -> `@Feature` -> `@Story` - combine your tests to a tree and split them by epic | feature | story


[Allure EE](https://qameta.io/) - this is like Allure + TestRail + CI. [Documentation](https://docs.qameta.io/allure-ee/) with features and etc.

#### The main fetures: 

`Live documentation` - Allure EE keeps your test documentation updated based on test runs.

`TMS` - Allure EE supports both Manual and Automated testing. Unified test documentation allows you to manage and review all your product tests from a single view. Also, it has a lot of filters and you can create custom fields and filters.

`Integrations` - Allure EE based on Allure and has the same integrations and many more with Jira and other systems.

`Metrics` - Allure EE supports many more metrics than Allure and you can integrate the system with Grafana and add custom metrics and etc.

`Migration` - Allure EE supports test-cases transfer from any TMS like TestRail and etc.

# How to run

#### Before start

You need to install `Selenoid and Selenoid-UI` and `Allure`

#### Notes

1. Those tests was splitted by `TAG` (annotation above test classes) and you need to check this before if you want to run only one group. 
2. If you want to run a few test classes please be sure you have free nodes for UI because all tests work in `PARALLEL` mode by class

#### Start

Run only one test group/tag: 

```bash
$ mvn clean test -D TAG=<tag name>
```
or
```bash
$ ./gradlew clean test -D TAG=<tag name>
```

Run all tests (UI and BACK):

```bash
$ mvn clean test
```
or
```bash
$ ./gradlew clean test
```
or
```bash
$ mvn clean test -D TAG=regress
```
[ONLY FOR UI] If you want to run the tests on the remote computer you need to transfer `HUB_URL` varaible to the env:
```bash
$ mvn clean test -D TAG=<tag name> -D HUB_URL=<ip or host>
```

#### After tests

If you want to see the test report locally: 
```bash
$ allure serve target/allure-results
```
or
```bash
$ allure serve target/allure-results --host localhost --port 9999
```

If you want just generate the test report without web service run:
```bash
$ allure generate target/allure-results
```
Go to `src/allure-report` folder and click `index.html`

#### CI

If you use Jenkins or TeamCity and etc. the report will be generated automatically after a run and connected with this job. You will need just click on the Allure logo! 
  
### Allure + Grafana

**Allure** generates a report specially for **Grafana** and **Prometheus**

How to use it for **Grafana**:
  - Generate **allure-report** by `$ allure generate allure-results`
  - Install **InfluxDB** (use **Docker**)
  - Get a file for **InfluxDB** in `/allure-report/export/influxDbData.txt`
  - Install **Grafana** (use **Docker**)
  - Integrate **InfluxDB** to **Grafana**
  - Send the report to **InfluxDB** by 
  - `$ curl -XPOST 'http://<host>/write?db=<db name>' --data-binary @allure-report/export/influxDbData.txt`
  - Check **Grafana** 
  - ***PROFIT***

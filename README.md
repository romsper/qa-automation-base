# Automation project

##### Description

This repository contains a few automation base projects which were written by **Kotlin** and **JavaScript**. All projects contains **Allure** and **Kotlin** projects contain examples with **Selenide**. I use **Selenoid** in Docker as the browser farm! 

##### Branches

  - [kotlin-testng-rest-assured](https://github.com/romsper/qa-automation-bases/tree/kotlin-testng-rest-assured) - Kotlin | Rest-Assured | Selenide | TestNG | Allure
  - [kotlin-junit5-retrofit](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-retrofit) - Kotlin | Retrofit | Selenide | JUnit 5 | Allure
  - [kotlin-junit5-appium](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-appium) - Kotlin | Selenide/Appium | JUnit 5 | Allure | Allure EE | TestRail
  - [js-mocha-chai](https://github.com/romsper/qa-automation-bases/tree/js-mocha-chai) - JS | Mocha | Chai | Allure
  
  
  
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



### Selenoid

**Selenoid** is a **Browsers farm** (like **Selenium Grid**) for automation testing which runs in a **Docker** and has **UI** interface with **StackTrace** and **VNC**. 

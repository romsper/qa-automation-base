# Automation project

##### Description

This repository contains a few automation base projects which were written by **Kotlin** and **JavaScript**. All projects contains **Allure** also **Kotlin** projects contains examples with **Selenide**

##### Branches

  - [kotlin-testng-rest-assured](https://github.com/romsper/qa-automation-bases/tree/kotlin-testng-rest-assured)
  - [kotlin-junit5-retrofit](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-retrofit)
  - [kotlin-junit5-appium](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-appium)
(Kotlin + Selenide/Appium + JUnit 5 + Allure + Allure EE + TestRail)
  - [js-mocha-chai](https://github.com/romsper/qa-automation-bases/tree/js-mocha-chai)
  
  
  
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

Distribute this tool to Docker is really easy - just use **3 commands** in **Terminal**:
  - Install **Selenoid** by `curl -s https://aerokube.com/cm/bash | bash \ && ./cm selenoid start --vnc`
  - Install **Selenoid UI** by `./cm selenoid-ui start --port 8080`
  - For **update** this **browsers** just use `./cm selenoid update`

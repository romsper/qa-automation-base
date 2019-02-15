# Automation project

##### Description

This project contains a few automation base projects which were written by Kotlin and JS.

Projects were written by **Kotlin** contains:
  - **Allure**
  - **AssertJ**
  - **Selenide**

Project was written by **JS** contains:
  - **Allure**
  - **Mocha**
  - **Chai**

##### Branch

Just select the desired branch 

  - [kotlin-testng-rest-assured](https://github.com/romsper/qa-automation-bases/tree/kotlin-testng-rest-assured)
  - [kotlin-junit5-retrofit](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-retrofit)
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
  `$ curl -XPOST 'http://<host>/write?db=<db name>' --data-binary @allure-report/export/influxDbData.txt`
  - Check **Grafana** 
  ***PROFIT***

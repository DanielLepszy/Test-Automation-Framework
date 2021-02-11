# Test-Automation-Framework
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is simple test framework, created to automate test process of open source [saucedemo](https://www.saucedemo.com/) web application.
Presently, the framework based on UI tests which are fully independent.
In the future, the QA process will be expanded with  **[REST API](https://www.redhat.com/en/topics/api/what-is-a-rest-api)** tests.

## Technologies
Project is created with:
* Java > 8
* JUnit 5
* Selenium WebDriver 
* Selenium Server 
* Selenium drivers:
    * Firefox
    * Chrome
* Gradle 

## Setup

### To run tests suites locally:
Use gradle task in cmd:

- #### Run suites test in firefox:
      $ gradle test -PBROWSER=BROWSER -PRUNNING_TYPE=RUNNING_TYPE

  > **where**:
  > * BROWSER ( firefox / chrome / edge )
  > * RUNNING_TYPE ( local / remote )

### To run tests suites remotely:

Before running, download selenium server .jar file in desire version and place to ***gridConfigFiles*** folder.
Currently, the project contains selenium-server-standalone-3.141.59.jar file.

- #### Start the hub distribution with specified configurations by execute gradle task in cmd:
       $ gradle startHub

  To add or edit hub configurations go to ***hubCondig.json*** file.
  
- #### Start grid nodes with configurations by execute gradle task in cmd:
      $ gradle copyDependencies startNode 
  All nodes configurations are placed in ***nodeConfig.json*** file.

- #### Run test suite:
      $ gradle test -PBROWSER=BROWSER -PRUNNING_TYPE=RUNNING_TYPE


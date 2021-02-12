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
Use gradle task to run tests in specific configuration:

      $ gradle test -PBROWSER=BROWSER -PBROWSER_VERSION=BROWSER_VERSION -PRUNNING_TYPE=RUNNING_TYPE -PPLATFORM=PLATFORM 
***WHERE :***
* **BROWSER** 
  - Firefox 
  - Chrome 
  - Edge


* **BROWSER_VERSION** ( *Check browser release notes to specify a stable version* ):
  - **[Firefox release]("https://www.mozilla.org/en-US/firefox/releases/")**
  - **[Chrome release]("https://www.chromestatus.com/features/schedule")**
  - **[Edge release]("https://docs.microsoft.com/en-us/deployedge/microsoft-edge-relnote-stable-channel")**


* **RUNNING_TYPE**
    - local 
    - remote


* **PLATFORM** :
    - WINDOWS - > *as a default value* 
    - XP 
    - VISTA 
    - WIN8 
    - WIN10 
    - MAC 
    - ANY
### To run tests suites locally:
  
- #### Run suites test in firefox:
      $ gradle test -PBROWSER=FIREFOX -PRUNNING_TYPE=LOCAL

Locally, the browser version is set to the newest as a default value.

### To run tests suites remotely:

Before running, download selenium server .jar file in desire version and place to ***gridConfigFiles*** folder.
Currently, the project contains selenium-server-standalone-3.141.59.jar file.

- #### Start the hub distribution with specified configurations  on a virtual machine:
       $ gradle startHub

  To add or edit hub configurations go to ***hubCondig.json*** file.
  
- #### Start grid nodes with configurations on a virtual machine as well:
      $ gradle copyDependencies startNode 
  All nodes configurations are placed in ***nodeConfig.json*** file.

- #### Run test suite:
      $ gradle test -PBROWSER=BROWSER -PBROWSER_VERSION=BROWSER_VERSION -PRUNNING_TYPE=REMOTE -PPLATFORM=PLATFORM 

There is need to specify browser version in gradle parameter.

Remember to match test configurations from gradle command( BROWSER / VERSION / PLATFORM ), you need specify
node with the same configuration in ***nodeConfig.json*** file.


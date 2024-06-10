## Mantis Automation with Selenium

This document provides instructions on how to set up and run the Selenium project.

Project Overview

This project demonstrates how to use Selenium WebDriver with Cucumber and JUnit to automate web browser interactions.
It includes features for navigating to a website, interacting with elements, and verifying results.



## Installation

- Prerequisites
    - Java Development Kit (JDK) 8 or higher
    - Maven 3 or higher
    - ChromeDriver (compatible with your Chrome browser version)

- Installing Dependencies
    - Clone or download the project repository.
    - Open a terminal and navigate to the project directory.
    - Run the following command to install the project dependencies:

## Scripts

To install the project dependencies
```bash
 mvn clean install
```

To run smoke tests

```bash
mvn test -Dtest=**/*RunCucumberTest -Dcucumber.options="--tags @smoke-test"
```

To run all tests

```bash
mvn test -Dtest=**/*RunCucumberTest"
```

To run with reports

```bash
mvn test -Dtest=**/*RunCucumberTest cluecumber-report:reporting
```

## Technologies Used

- Selenium WebDriver
- Cucumber
- JUnit
- Maven
- ChromeDrive

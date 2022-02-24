![](https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/screenshot.png "PrestaShop tests")

# PrestaShop tests

## Technology stack

|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/java.svg "Java")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/junit5.svg "JUnit5")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/gradle.svg "Gradle")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/selenide.svg "Selenide")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/rest-assured.svg "Rest-Assured")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/jenkins.svg "Jenkins")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/selenoid.svg "Selenoid")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/allurereport.svg "Allure Report")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/alluretestops.svg "Allure TestOps")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/jira.svg "Jira")|![](https://github.com/w3code/web-api-auto-project/raw/main/assets/icons/telegram.svg "Telegram")|
| :--------: |:--------: | :--------: | :--------: | :--------: | :--------: | :--------: | :--------: | :--------: | :--------: | :--------: |
| Java | JUnit5 | Gradle | Selenide | Rest-Assured | Jenkins | Selenoid | Allure Report | Allure TestOps | Jira | Telegram

## Covered cases

- [x] UI login test
- [x] API login test
- [x] Modify profile name test
- [x] Add to wishlist test
- [x] Add to cart test

## How to run

The project can be launched by two ways. You can choose the way by setting up the `-Denvironment=` parameter.

- ##### To run tests with selenoid platform and selenoid.properties:

    ```sh
      gradle clean test -Denvironment=selenoid
    ```

- ##### To run tests local with browser.properties:

    ```sh
      gradle clean test
    ```

## Jenkins

> Jenkins is an open source automation server. It helps automate 
> the parts of software development related to building, testing, 
> and deploying, facilitating continuous integration and continuous delivery.
> To run autotests in Jenkins you can choose the `BROWSER` and `BROWSER_VERSOIN` parameter.

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/jenkins_params.png">
</p>

After the build is finished you can view the Allure Report for this build.

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/jenkins_project.png">
</p>

## Allure Report

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/allure_report_1.png">
</p>

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/allure_report_2.png">
</p>

## Allure TestOps

### Launches

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/allure_testops_launches.png">
</p>

### Dashboards

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/allure_testops_dashboards.png">
</p>

### Launch Tree

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/allure_testops_cases.png">
</p>

## Jira

> Jira used as bugtrecking system with Allure TestOps integration

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/jira.png">
</p>

## Selenoid video

#### UI login test
![](https://github.com/w3code/web-api-auto-project/raw/main/assets/gif/uilogintest.gif "UI login test")

#### API login test
![](https://github.com/w3code/web-api-auto-project/raw/main/assets/gif/apilogintest.gif "API login test")

#### Modify profile name test
![](https://github.com/w3code/web-api-auto-project/raw/main/assets/gif/modifyprofilenametest.gif "Modify profile name test")

#### Add to wishlist test
![](https://github.com/w3code/web-api-auto-project/raw/main/assets/gif/addtowishlisttest.gif "Add to wishlist test")

#### Add to cart test
![](https://github.com/w3code/web-api-auto-project/raw/main/assets/gif/addtocarttest.gif "Add to cart test")

## Telegram notifications

<p align="center">
  <img src="https://github.com/w3code/web-api-auto-project/raw/main/assets/screenshots/tlg.jpg">
</p>

## Contact

#### Telegram: [@w3c0de](https://t.me/w3c0de)
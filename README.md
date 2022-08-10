# Unit & UI tests
<b id="f1"></b> <h2>The framework is based on:</h2>
- Java 11 
- Maven 
- Selenium WD and Selenide
- TestNG
- Allure
- Lombok
## Infrastructure
There are two main branches in the project for now:<br>
`master` allows you to run the project locally. See _"Initial Framework Configuration & How to run tests locally"_ section below.<br>
`production` allows you to run the tests remotely and get the generated reports in GitHub. See _"CI process & How to run tests remotely
"_ section below.<br>
## CI process & How to run tests remotely
### The process basics:
- GitHub Actions - as CI tool
- GitHub Pages - service to publish a website directly on GitHub from a Git repository for Allure Report
- Selenoid for running tests remotely
### To run tests remotely:
1. Open project https://github.com/olga27zl/solution/
2. Go to **Actions** tab
3. Click on **"Run the tests"** to open workflow run 
4. Click **"Re-run all the jobs"** in the top right corner (or you can trigger the tests run by pushing commits to the project)
5. Confirm by clicking on **"Re-run jobs"** on the modal
5. Wait until build is finished
6. Go to **"All workflows"**
7. Wait until new **"pages build and deployment"** finished
8. Open it by clicking on this run
9. Below **'deploy'** click on the link
10. Observe Allure reports
## Initial Framework Configuration & How to run tests locally
### How to install?
1. Clone project https://github.com/olga27zl/solution
2. Open project in Intellij Idea
3. Make sure you have installed Java 11 and maven on your machine and set the environment variables
### How to run unit tests?
1. The unit tests for pickOutVowels() function is in "src/test/java/com/example/solution/unit/SolutionTest.java"
2. In terminal navigate to the project directory
3. To run unit test suite in terminal: *mvn test -Dtest="com.example.solution.unit.SolutionTest"*
4. Alternately you can run the suite with TestNG runner via IDE
### How to run UI login tests?
1. The UI tests for login is in "src/test/java/com/example/solution/ui/LoginTest.java"
2. In terminal navigate to the project directory
3. To run unit test suite in terminal: *mvn test -Dtest="com.example.solution.ui.LoginTest"*
4. Alternately you can run the suite with TestNG runner via IDE
### How to see the test results?
1. When test run is finished, in the project directory you can see allure-results folder
2. Install allure (for Mac OS it would be: *brew install allure* or for Windows: *scoop install allure*)
3. Run *allure generate --clean* in the directory where allure-results folder is
4. Afterward open allure-report folder
5. Navigate to a browser through *index.html* file
## IDEA Configuration
### Necessary Plugins
- Lombok Plugin
### How to install plugin
1. Open IDEA Settings (Ctrl+Alt+S or File > Settings)
2. In search field type 'Plugins'
3. In Plugins window open Marketplace tab
4. For Marketplace window in search field type necessary plugin name
5. Click 'Install' button
6. After successfully installing click 'Restart IDE'
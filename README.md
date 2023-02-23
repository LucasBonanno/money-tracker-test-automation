# Introduction

This maven project is based on a BDD technique of development (Behavior Driven Development). Using Java and Gherkin with Selenium framework and JUnit and Cucumber tools.

# Requirements

Project money-tracker is wanted for this one, so it will be necessary to have project money-tracker ready at http://localhost:3000/

For more information on how to do this follow the guide: https://github.com/ayastreb/money-tracker

To execute this application is necessary:
1.	Lombok
2.	JDK 11
3.	Maven
4.  Chrome Browser
5.  money-tracker Project

### Installation guide
- Clone the project from repo to have access: https://github.com/LucasBonanno/money-tracker-test-automation


- Install Java JDK 11, according to your operating system:  https://www.oracle.com/pt/java/technologies/javase/jdk11-archive-downloads.html


- Download Maven Apache, according to your operating system: 
https://maven.apache.org/download.cgi


- You will need the SDK and Apache Maven in your system variables, here are some quick tips:
  
  Java Tips - https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html
  Apache Maven Tips - https://maven.apache.org/install.html or https://docs.oracle.com/en/java/javase/15/install/installation-jdk-macos.html (For MacOs)


- If you are using the Eclipse IDE, you will need to download the lombok .jar for this solution to work properly.
  With the Intellij IDE this will not be necessary, it is already supported.
  Lombok Tips - https://projectlombok.org/


- Is necessary to have Cucumber plugin installed in your IDE.
  Cucumber Eclipse Tips - https://marketplace.eclipse.org/content/cucumber-eclipse-plugin
  Cucumber Intellij Tips - https://plugins.jetbrains.com/plugin/7212-cucumber-for-java

**PS**:

The Chrome browser was chosen for this project. Selenium use a driver to manipulate the screen, it is necessary to change the version according to your browser version.

Chrome Tips - find out the version of here: chrome://settings/help

To change the version to be used in the project, go to: **src/main/java/com/parsly/configurations/DriverFactory.java**

In **getDriver()** method, and just put the version according to your browser.

Change like this example: WebDriverManager.chromedriver().version( **"110.0"** ).setup();

# Automation Technology
-	Java
-	Selenium
-	Cucumber
-	Junit

Project Tested:
money-tracker - https://github.com/ayastreb/money-tracker

### To execute the Tests Cases

Just run in the root of the project via command line: **mvn clean install**

or

**CucumberExecuteTest.class** was structured as runner
To execute, just add into "tags" your tag annotation from @CucumberOptions
Exemple:
@RunWith( Cucumber.class )
@CucumberOptions(
features = "classpath:features",
glue = {
"com.parsly"
},
**tags** = "@RegressionTests",
plugin = { "pretty", "html:evidences/pretty-cucumber-report.html" },
snippets = CucumberOptions.SnippetType.CAMELCASE,
publish = true

)
public class CucumberExecuteTest {

}

This runner class: **src/test/java/com/parsly/main**

All Tests Cases: **src/test/resources/features**

### Note:

After running the tests. The evidences can be found in the folder named: **evidences**

One of the Expense Transaction tests is deliberately showing an error in the tested system. So this test fails because it finds a bug.

### Contact:

Any question? Please let me know at: **lucas.bonani@gmail.com**

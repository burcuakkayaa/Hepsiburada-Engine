# Hepsiburada-Engine
The Project has been develop with Selenium & Java8 
Each user can create Allure & Cucumber Report.


There are several different approach to run test case.
* You can write the terminal "mvn clean install". After that you will see running test cases.
* You can trigger the cucumber feature file.
* You can trigger TestRunner.java.

If you want to create Allure report, firstly make sure allure framework is exist on your local. You can follow the page to confiure it.--> https://docs.qameta.io/allure-report/
After the installation, run test cases, you will see allure-result file in the project.
Open the terminal and write "allure serve", that's all. Allure Report is automatically created.

  @chrome
  Scenario: Hepsiburada - Happy Path - Adding different seller's products
    Given user visits hepsiburada.com
    When user searches "canta"
    And user selects 1 product from product list
    And user selects different seller's of the product
    And user clicks Basket button
    Then user see that there are selected products at the Cart Page
    
    ![image](https://user-images.githubusercontent.com/62480904/213889659-b3bd3090-7d0e-40d8-83fd-8ca6ab4f3276.png)

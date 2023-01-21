package myStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import static myHooks.BaseHook.driver;

public class HomePageSteps {

    @Given("user visits Hepsiburada.com")
    public void user_visits_hepsiburada_com() {
        /**
         * Verify that the webpage is opened
         */
        HomePage homePage = new HomePage(driver);
        homePage.visitWebPage();

    }
    @Given("user searches a product with {string}")
    public void user_searches_a_product_with(String string) {

    }
    @Then("user blabla")
    public void user_blabla() {

    }
}

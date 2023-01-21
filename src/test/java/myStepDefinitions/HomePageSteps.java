package myStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static myHooks.BaseHook.driver;

public class HomePageSteps {
    HomePage homePage = new HomePage(driver);

    @Given("user visits Hepsiburada.com")
    public void user_visits_hepsiburada_com() {
        /**
         * Verify that the webpage is opened
         */

        homePage.visitWebPage();
        if (!homePage.urlContains("Hepsiburada"))
            Assert.fail("The webpage can not loaded!");

    }

    @When("user searches a product with {string}")
    public void user_searches_a_product_with(String search) {
        /**
         * Search product with a name
         * @param str search : the product name
         */

        homePage.searchProduct(search);
    }
}

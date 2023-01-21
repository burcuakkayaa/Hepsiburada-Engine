package myStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class HomePageSteps extends BaseSteps {

    @Given("user visits hepsiburada.com")
    public void user_visits_hepsiburada_com() {
        /**
         * Verify that the webpage is opened
         */

        homePage.visitWebPage();
        homePage.acceptCookies();
        Assert.assertTrue(homePage.urlContains("hepsiburada"), "The webpage can not loaded!");

    }

    @When("user searches {string}")
    public void user_searches(String search) {
        /**
         * Search product with a name
         * @param str search : the product name
         */

        homePage.searchProduct(search);
        Assert.assertTrue(searchDetailsPage.verifyPageIsOpened(search), "Search Details Page can not be present!");
        Assert.assertTrue(searchDetailsPage.verifyResultSummary(search), "The search result can not founded!");
    }

    @And("user clicks Basket button")
    public void userClicksBasketButton() {
        /**
         * Clicks the basket button and opens the Cart Page
         */
        homePage.clickBasketButton();
    }
}

package myStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Constant;

import java.time.Duration;

import static myHooks.BaseHook.driver;

public class HomePageSteps {

    @Given("user visits Hepsiburada.com")
    public void user_visits_hepsiburada_com() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(Constant.BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Constant.IMPLICIT_WAIT_DURATION)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(Constant.PAGE_LOAD_TIMEOUT)));
    }
    @Given("user searches a product with {string}")
    public void user_searches_a_product_with(String string) {

    }
    @Then("user blabla")
    public void user_blabla() {

    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constant;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'searchBoxOld')]//input")
    WebElement searchBar;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookiesButton;

    @FindBy(id = "cartItemCount")
    WebElement cartItemCount;

    @FindBy(id = "shoppingCart")
    WebElement basketButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visitWebPage() {
        navigateUrl(Constant.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Constant.IMPLICIT_WAIT_DURATION)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(Constant.PAGE_LOAD_TIMEOUT)));
    }

    public Boolean urlContains(String text) {
        /**
         * Return url contains expected text or not
         * @param str text: expected text for the Url
         */
        Boolean flag = Boolean.TRUE;
        if (Boolean.FALSE.equals(waitUntilUrlContains(text))) {
            flag = Boolean.FALSE;
        }
        return flag;
    }

    public void searchProduct(String search) {
        /**
         * Search product with a name
         * @param str search : the product name
         */

        waitForElementClickable(searchBar).sendKeys(search);
        clickEnter();
    }

    public void acceptCookies() {
        /**
         * Clicks the accept cookies button
         */

        waitForElementClickable(acceptCookiesButton).click();
    }

    public void clickBasketButton() {
        /**
         * Clicks basket button from header
         */
        waitForElementClickable(basketButton).click();

        new CartPage(driver);
    }
}

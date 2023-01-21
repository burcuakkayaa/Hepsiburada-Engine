package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constant;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(css = "[aria-owns='react-autowhatever-1']")
    WebElement searchBar;

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
        if (!waitUntilUrlContains(text)) {
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
}

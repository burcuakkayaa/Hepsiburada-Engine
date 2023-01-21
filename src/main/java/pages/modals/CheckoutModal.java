package pages.modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class CheckoutModal extends BasePage {

    @FindBy(css = "[class*='checkoutui-ProductOnBasketHeader'] button")
    List<WebElement> checkoutButtons;

    @FindBy(className = "checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz")
    WebElement successAddToCartMessage;

    @FindBy(className = "checkoutui-Modal-iHhyy79iR28NvF33vKJb")
    WebElement closeButton;

    @FindBy(className = "checkoutui-Modal-IAYMPfHUm0giU1ze9D0C")
    WebElement checkoutModal;

    @FindBy(css = "[class='checkoutui-ProductOnBasketHeader-Jv_tgxl9ipeCC7ozGAgI'] span")
    WebElement seller;

    @FindBy(css = "[class=checkoutui-Modal-IAYMPfHUm0giU1ze9D0C] h6")
    WebElement productName;

    public CheckoutModal(WebDriver driver) {
        super(driver);
        check();
    }

    public void check() {
        waitForLoad();
        Assert.assertTrue(waitForElementVisible(checkoutModal).isDisplayed(), "Checkout Modal can not displayed!");
        Assert.assertTrue(waitForElementVisible(closeButton).isDisplayed(), "Close button can not displayed!");
        Assert.assertTrue(waitForElementVisible(successAddToCartMessage).isDisplayed(), "Success Message can not displayed!");
        Assert.assertTrue(visibilityOfAllElements(checkoutButtons).get(0).isDisplayed(), "Checkout button can not displayed!");

    }

    public void clickCloseButton() {
        /**
         * Clicks close checkout modal button
         */

        waitForElementClickable(closeButton).click();
    }

    public String getSellerName() {
        /**
         * Gets and Returns the product seller name
         */

        return waitForElementVisible(seller).getText();
    }

    public String getProductName() {
        /**
         * Gets and Returns the product name
         */

        return waitForElementVisible(productName).getText();
    }
}

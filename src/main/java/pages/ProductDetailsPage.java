package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.modals.CheckoutModal;
import utils.Products;

import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "product-name")
    WebElement productName;

    @FindBy(id = "offering-price")
    WebElement productPrice;

    @FindBy(css = "[class='seller'] span a")
    WebElement sellerName;

    @FindBy(id = "addToCart")
    WebElement addToCartButton;

    @FindBy(css = "[class='add-to-basket button small']")
    List<WebElement> otherSellerAddToCartButton;

    @FindBy(css = "[class='price-text']")
    List<WebElement> otherSellerPrice;

    private String name;
    private String price;
    private String seller;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void check() {
        switchToNewWindow();
        waitForLoad();
        Assert.assertTrue(waitForElementVisible(addToCartButton).isDisplayed(), "Add to Cart button can not displayed!");
        Assert.assertTrue(waitForElementVisible(productName).isDisplayed(), "Product Name can not displayed!");
        Assert.assertTrue(waitForElementVisible(productPrice).isDisplayed(), "Product Price can not displayed!");
        Assert.assertTrue(waitForElementVisible(sellerName).isDisplayed(), "Seller Name can not displayed!");

    }

    public String getName() {
        /**
         * Gets and Returns product name
         */

        return waitForElementVisible(productName).getText();
    }

    public String getPrice() {
        /**
         * Gets and Returns product price
         */

        return waitForElementVisible(productPrice).getText();
    }

    public String getSeller() {
        /**
         * Gets and Returns product seller
         */

        return waitForElementVisible(sellerName).getText();
    }

    public CheckoutModal clickAddToCartButton() {
        /**
         * Clicks 'Add to Cart' button
         */

        waitForElementClickable(addToCartButton).click();
        return new CheckoutModal(driver);
    }

    public Products clickAnotherSellerAddToCartButton() {
        /**
         * Clicks Another Seller's 'Add to Cart' button and returns the selected product price
         */

        scrollElement(otherSellerAddToCartButton.get(0));
        waitForElementClickable(otherSellerAddToCartButton.get(0)).click();
        CheckoutModal checkoutModal = new CheckoutModal(driver);

        Products product = new Products();
        product.setProductName(checkoutModal.getProductName());
        product.setPrice(waitForElementVisible(otherSellerPrice.get(0)).getText());
        product.setSellerName(checkoutModal.getSellerName());

        checkoutModal.clickCloseButton();
        return product;
    }
}

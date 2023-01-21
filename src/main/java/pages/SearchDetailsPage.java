package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.modals.CheckoutModal;
import utils.Products;

import java.util.List;

public class SearchDetailsPage extends BasePage {


    @FindBy(className = "searchResultSummaryBar-AVnHBWRNB0_veFy34hco")
    List<WebElement> resultSummaryBar;

    @FindBy(css = "li[id*='i']")
    List<WebElement> productList;

    @FindBy(css = "li[id*='i'] [data-test-id='product-card-name']")
    List<WebElement> productNameList;

    @FindBy(css = "li[id*='i'] [data-test-id='product-card-name'] span")
    List<WebElement> sellerNames;

    @FindBy(css = "li[id*='i'] [data-test-id='price-current-price']")
    List<WebElement> priceList;

    @FindBy(css = "[data-test-id='product-info-button']")
    WebElement addToBasketButton;

    @FindBy(className = "hb-toast-text")
    WebElement toastMessage;

    public SearchDetailsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean verifyPageIsOpened(String text) {
        /**
         * Returns that Search Detail Page is opened or not
         * @param str text: Search text
         */

        Boolean flag = Boolean.TRUE;
        if (Boolean.FALSE.equals(waitUntilUrlContains(text))) {
            flag = Boolean.FALSE;
        }
        return flag;
    }

    public Boolean verifyResultSummary(String search) {
        /**
         * Returns Search results are present or not
         * @param str search: search key
         */
        Boolean flag = Boolean.TRUE;
        if (!visibilityOfAllElements(resultSummaryBar).get(0).getText().equalsIgnoreCase(search)) {
            flag = Boolean.FALSE;
        }
        return flag;

    }

    public Products selectAProduct(int productNumber) {
        /**
         * Selects a product, clicks the basket button and returns the product details
         * @param int productNumber: The product number of the product list
         */

        WebElement product = productList.get(productNumber);
        scrollElement(product);
        ProductDetailsPage productDetailsPage = clickProductDetails(product);
        productDetailsPage.check();
        String productName = productDetailsPage.getName();
        String price = productDetailsPage.getPrice();
        String sellerName = productDetailsPage.getSeller();

        CheckoutModal checkoutModal = productDetailsPage.clickAddToCartButton();
        checkoutModal.clickCloseButton();

        return setProductDetails(productName, sellerName, price);
    }

    private ProductDetailsPage clickProductDetails(WebElement product) {
        /**
         * Clicks the product and see the product details
         */

        waitForElementClickable(product).click();

        return new ProductDetailsPage(driver);
    }


    private Products setProductDetails(String productName, String sellerName, String price) {
        /**
         * Sets product details
         * @param str productName: The name of the product
         * @param str sellerName: The seller name of the product
         * @param str price: The product price
         */

        Products product = new Products();
        product.setProductName(productName);
        product.setSellerName(sellerName);
        product.setPrice(price);

        return product;

    }
}

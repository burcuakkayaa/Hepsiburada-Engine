package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Products;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "continue_step_btn")
    WebElement continueButton;

    @FindBy(css = "[class='product_name_3Lh3t']")
    List<WebElement> productNameList;

    @FindBy(css = "[class='merchantLink_2Ii8s'] a")
    List<WebElement> productSellers;

    @FindBy(css = "[class*='item_list'] [data-test-id='price-current-price']")
    List<WebElement> productPriceList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void check() {
        waitForLoad();
        Assert.assertTrue(waitForElementVisible(continueButton).isDisplayed(), "Continue button can not present!");
        Assert.assertTrue(visibilityOfAllElements(productNameList).get(0).isDisplayed(), "There is no product in the Cart Page");
        Assert.assertTrue(visibilityOfAllElements(productSellers).get(0).isDisplayed(), "There is no product seller name in the Cart Page");
        Assert.assertTrue(visibilityOfAllElements(productPriceList).get(0).isDisplayed(), "There is no product price in the Cart Page");

    }

    public List<String> getProductNamelist() {
        /**
         * Gets and Returns Product name list from the Cart Page
         */

        List<String> productsName = new ArrayList<>();

        for (int i = 0; i < productNameList.size(); i++) {
            scrollElement(productNameList.get(i));
            productsName.add(waitForElementVisible(productNameList.get(i)).getText());
        }
        return productsName;
    }

    public List<String> getProductSellerNamelist() {
        /**
         * Gets and Returns Product Seller name list from the Cart Page
         */

        List<String> productSellersName = new ArrayList<>();

        for (int i = 0; i < productSellers.size(); i++) {
            scrollElement(productSellers.get(i));
            productSellersName.add(waitForElementVisible(productSellers.get(i)).getText());
        }
        return productSellersName;
    }

    public List<String> getProductPricelist() {
        /**
         * Gets and Returns Products Price list from the Cart Page
         */

        List<String> productsPrice = new ArrayList<>();

        for (int i = 0; i < productPriceList.size(); i++) {
            scrollElement(productPriceList.get(i));
            productsPrice.add(waitForElementVisible(productPriceList.get(i)).getText());
        }
        return productsPrice;
    }

    public void verifyTheNumberOfProducts(int size) {
        /**
         * Verify the number of the products into the Cart Page
         * @param int size: the number of the products
         */

        Assert.assertEquals(visibilityOfAllElements(productNameList).size(), size, "The number of products can not mismatch!");
    }

    public void verifyTheNameOfProducts(List<Products> selectedProductList) {
        /**
         * Verify the name of the products into the Cart Page
         * @param List<Products> selectedProductList: Selected product list
         */

        for (int i = 0; i < selectedProductList.size(); i++) {
            Assert.assertTrue(visibilityOfAllElements(productNameList).get(selectedProductList.size() - 1 - i).getText().contains(selectedProductList.get(i).getProductName()), "The product names can not mismatch!");
        }
    }

    public void verifyThePriceOfProducts(List<Products> selectedProductList) {
        /**
         * Verify the price of the products into the Cart Page
         * @param List<Products> selectedProductList: Selected product list
         */

        for (int i = 0; i < selectedProductList.size(); i++) {
            Assert.assertEquals(selectedProductList.get(selectedProductList.size() - 1 - i).getPrice(), visibilityOfAllElements(productPriceList).get(i).getText(), "The product prices can not mismatch!");
        }
    }

    public void verifyTheSellerNameOfProducts(List<Products> selectedProductList) {
        /**
         * Verify the Seller Name of the products into the Cart Page
         * @param List<Products> selectedProductList: Selected product list
         */

        for (int i = 0; i < selectedProductList.size(); i++) {
            Assert.assertEquals(selectedProductList.get(selectedProductList.size() - 1 - i).getSellerName(), visibilityOfAllElements(productSellers).get(i).getText(), "The product seller name can not mismatch!");
        }
    }
}

package myStepDefinitions;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchDetailsPage;
import utils.Products;

import java.util.ArrayList;
import java.util.List;

import static myHooks.BaseHook.driver;


public class BaseSteps {

    SearchDetailsPage searchDetailsPage = new SearchDetailsPage(driver);
    static List<Products> selectedProductList = new ArrayList<>();
    HomePage homePage = new HomePage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    CartPage cartPage = new CartPage(driver);

}

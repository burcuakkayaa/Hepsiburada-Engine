package myStepDefinitions;

import io.cucumber.java.en.Then;

public class CartPageSteps extends BaseSteps {

    @Then("user see that there are selected products at the Cart Page")
    public void userSeeThatThereAreSelectedProductsAtTheCartPage() {
        /**
         * Verify Cart Page is opened and each Product have been added
         */
        cartPage.check();
        cartPage.verifyTheNumberOfProducts(selectedProductList.size());
        cartPage.verifyTheNameOfProducts(selectedProductList);
        cartPage.verifyThePriceOfProducts(selectedProductList);
        cartPage.verifyTheSellerNameOfProducts(selectedProductList);
    }
}

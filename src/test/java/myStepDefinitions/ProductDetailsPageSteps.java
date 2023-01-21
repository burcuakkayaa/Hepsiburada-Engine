package myStepDefinitions;

import io.cucumber.java.en.And;

public class ProductDetailsPageSteps extends BaseSteps {

    @And("user selects different seller's of the product")
    public void userSelectsDifferentSellerSOfTheProduct() {
        /**
         * Selects another product from the different seller and adds into the selected product list
         */

        selectedProductList.add(productDetailsPage.clickAnotherSellerAddToCartButton());
    }
}

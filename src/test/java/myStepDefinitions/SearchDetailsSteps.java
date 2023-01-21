package myStepDefinitions;

import io.cucumber.java.en.And;

public class SearchDetailsSteps extends BaseSteps {

    @And("user selects {int} product from product list")
    public void userSelectsProductFromProductList(int productNumber) {
        /**
         * Selects a product from the product list and adding to the selected product list
         */
        selectedProductList.add(searchDetailsPage.selectAProduct(productNumber - 1));
    }
}

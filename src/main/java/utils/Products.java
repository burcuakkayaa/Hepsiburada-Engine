package utils;

public class Products {

    private String sellerName;
    private String productName;
    private String price;

    public String getSellerName() {
        /**
         * Gets Seller Name
         */
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        /**
         * Sets Seller Name
         * @param str sellerName
         */
        this.sellerName = sellerName;
    }

    public String getProductName() {
        /**
         * Gets Product Name
         */
        return productName;
    }

    public void setProductName(String productName) {
        /**
         * Sets Product Name
         * @param str productName
         */
        this.productName = productName;
    }

    public String getPrice() {
        /**
         * Get Product Price
         */
        return price;
    }

    public void setPrice(String price) {
        /**
         * Sets Product Price
         * @param str price
         */
        this.price = price;
    }
}

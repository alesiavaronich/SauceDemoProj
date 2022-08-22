package pages.services;

import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class AddProductToCartService {
    private WebDriver driver;

    public AddProductToCartService(WebDriver driver) {
        this.driver = driver;
    }

    public void addSingleProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartOnesie();
    }
}

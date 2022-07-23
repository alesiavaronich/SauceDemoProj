package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Double.parseDouble;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private By priceOfOnesieInCart = By.xpath("//button[@data-test='remove-sauce-labs-onesie']/preceding-sibling::div[text()='7.99']");
    private By continueShoppingButton = By.xpath("//button[@data-test='continue-shopping']");
    private By removeOnesieFromCart = By.xpath("//button[@data-test='remove-sauce-labs-onesie']");

    public void openCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.goToCart();
    }

    public void openEmptyCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.goToEmptyCart();
    }

    public double getOnesiePriceInCart() {
        double result = parseDouble(driver.findElement(priceOfOnesieInCart).getText().replace("$",""));
        return result;
    }

    public void continueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    public void removeOnesieFromCart() {
        driver.findElement(removeOnesieFromCart).click();
    }


}

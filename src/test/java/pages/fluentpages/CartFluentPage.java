package pages.fluentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

import static java.lang.Double.parseDouble;

public class CartFluentPage extends BaseFluentPage {

    private By priceOfOnesieInCart = By.xpath("//button[@data-test='remove-sauce-labs-onesie']/preceding-sibling::div[text()='7.99']");
    private By continueShoppingButton = By.xpath("//button[@data-test='continue-shopping']");
    private By removeOnesieFromCart = By.xpath("//button[@data-test='remove-sauce-labs-onesie']");

    public CartFluentPage(WebDriver driver) {
        super(driver);

    }

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

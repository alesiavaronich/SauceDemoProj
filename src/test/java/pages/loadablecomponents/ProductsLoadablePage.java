package pages.loadablecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ProductsLoadablePage extends BaseLoadableComponent {

    private By addToCartButtonForOnesie = By.xpath("//button[@data-test='add-to-cart-sauce-labs-onesie']");
    private By removeButtonForOnesie = By.xpath("//button[@data-test='remove-sauce-labs-onesie']");
    private By addToCartButtonForFleeceJacket = By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']");
    private By removeButtonForFleeceJacket = By.xpath("//button[@data-test='remove-sauce-labs-fleece-jacket']");
    private By emptyShoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartContainsItemLink = By.xpath("//a[@class='shopping_cart_link']/span");
    private By priceOfOnesie = By.xpath("//div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/div[text()='7.99']");

    public ProductsLoadablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return isShoppingCartIconDisplayed();
    }

    public boolean isShoppingCartIconDisplayed() {
        return driver.findElement(emptyShoppingCartLink).isDisplayed();
    }

    public void addToCartOnesie() {
        driver.findElement(addToCartButtonForOnesie).click();
    }

    public void addToCartFleeceJacket() {
        driver.findElement(addToCartButtonForFleeceJacket).click();
    }

    public void removeFleeceJacketFromCart() {
        driver.findElement(removeButtonForFleeceJacket).click();
    }

    public int getItemCountFromShoppingCart() {
        int result = parseInt(driver.findElement(shoppingCartContainsItemLink).getText());
        return result;
    }

    public boolean isShoppingCartEmpty() {
        String result = driver.findElement(emptyShoppingCartLink).getText();
        if(result == "") {
            return true;
        } else {
            return false;
        }
    }

    public double getOnesiePrice() {
        double result = parseDouble(driver.findElement(priceOfOnesie).getText().replace("$",""));
        return result;
    }

    public void goToCart() {
        driver.findElement(shoppingCartContainsItemLink).click();
    }

    public void goToEmptyCart() {
        driver.findElement(emptyShoppingCartLink).click();
    }




}

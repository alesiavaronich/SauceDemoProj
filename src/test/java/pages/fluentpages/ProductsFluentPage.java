package pages.fluentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ProductsFluentPage extends BaseFluentPage {

    private By productsSpanTitle = By.xpath("//div[@class='header_secondary_container']/span[text()='Products']");
    private By addToCartButtonForOnesie = By.xpath("//button[@data-test='add-to-cart-sauce-labs-onesie']");
    private By removeButtonForOnesie = By.xpath("//button[@data-test='remove-sauce-labs-onesie']");
    private By addToCartButtonForFleeceJacket = By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']");
    private By removeButtonForFleeceJacket = By.xpath("//button[@data-test='remove-sauce-labs-fleece-jacket']");
    private By emptyShoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartContainsItemLink = By.xpath("//a[@class='shopping_cart_link']/span");
    private By priceOfOnesie = By.xpath("//div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/div[text()='7.99']");


    public ProductsFluentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsSpanTitleDisplayed() {
        return driver.findElement(productsSpanTitle).isDisplayed();
    }

    public ProductsFluentPage addToCartOnesie() {
        driver.findElement(addToCartButtonForOnesie).click();
        return this;
    }

    public ProductsFluentPage addToCartFleeceJacket() {
        driver.findElement(addToCartButtonForFleeceJacket).click();
        return this;
    }

    public ProductsFluentPage removeFleeceJacketFromCart() {
        driver.findElement(removeButtonForFleeceJacket).click();
        return this;
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

    public CartFluentPage goToCart() {
        driver.findElement(shoppingCartContainsItemLink).click();
        return new CartFluentPage(driver);
    }

    public CartFluentPage goToEmptyCart() {
        driver.findElement(emptyShoppingCartLink).click();
        return new CartFluentPage(driver);
    }




}

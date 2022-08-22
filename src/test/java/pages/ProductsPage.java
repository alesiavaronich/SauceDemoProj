package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.Double.parseDouble;

@Log4j
public class ProductsPage extends BasePage {

    private By addToCartButtonForOnesie = By.xpath("//button[@data-test='add-to-cart-sauce-labs-onesie']");
    private By removeButtonForOnesie = By.xpath("//button[@data-test='remove-sauce-labs-onesie']");
    private By addToCartButtonForFleeceJacket = By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']");
    private By removeButtonForFleeceJacket = By.xpath("//button[@data-test='remove-sauce-labs-fleece-jacket']");
    private By emptyShoppingCartLink = By.xpath("//a[@class='shopping_cart_link']/span");
    private By shoppingCartContainsItemLink = By.xpath("//a[@class='shopping_cart_link']/span");
    private By priceOfOnesie = By.xpath("//div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/div[text()='7.99']");
    private By inventoryItemImg = By.xpath("//div[@class='inventory_item_img']/a/img");

    public ProductsPage(WebDriver driver) {
        super(driver);
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
        try {
            int count = Integer.parseInt(driver.findElement(shoppingCartContainsItemLink).getText());
            log.debug(String.format("Number of items in cart: $s", count));
            return count;
        } catch (NoSuchElementException e) {
            log.debug(String.format("<span> element was not found, therefore cart is empty"));
            return 0;
        }
    }

    public boolean isShoppingCartEmpty() {
        try {
            driver.findElement(emptyShoppingCartLink).getText();
            log.debug(String.format("<span> element was found, therefore item was placed into cart"));
            return true;
        } catch (NoSuchElementException e) {
            log.debug(String.format("<span> element was not found, therefore cart is empty"));
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

    public boolean validateTextFromButton() {
        String actual = driver.findElement(addToCartButtonForOnesie).getText();
        String expected = "Add to cart";
        return actual.equalsIgnoreCase(expected);
    }



}

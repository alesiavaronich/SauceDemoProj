package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorsExercise {

    WebDriver driver;

    public LocatorsExercise(WebDriver webDriver) {
        this.driver = webDriver;
    }

    //LoginPage
    private By pageTitle = By.tagName("title");
    private By username = By.cssSelector("[data-test='username']");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("[data-test='login-button']");

    //ProductsPage
    private By addToCartButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-onesie']");
    private By removeButton = By.xpath("//button[@data-test='remove-sauce-labs-onesie' and contains(text(),'Remove')]");
    private By inventoryItemImage = By.xpath("//a[@id='item_4_img_link']/img");
    private By inventoryItemImageCount = By.cssSelector("[class='inventory_item_img']");
    private By priceOfOnesie = By.xpath("//div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/div[text()='7.99']");
    private By burgerMenuButton = By.id("react-burger-menu-btn");
    private By linkedInLinkOnProductsPage = By.linkText("LinkedIn");
    private By facebookLinkOnProductsPage = By.partialLinkText("Face");
    private By productSortContainer = By.xpath("//select[@data-test='product_sort_container']");
    private By productSortContainerOptionLoHi = By.xpath("//option[text()='Price (low to high)']");
    private By productSortContainerOptionAZ = By.xpath("//option[contains(@value,'az')]");
    private By productSortContainerOptionHiLo = By.xpath("//option[contains(text(),'Price')]");
    private By primaryHeader = By.xpath("//div[@id='shopping_cart_container']//ancestor::div[contains(@class,'primary')]");
    private By productsContainer = By.xpath("//select[@data-test='product_sort_container']//parent::span");

    //CartPage
    private By cartQuantity = By.cssSelector(".cart_quantity");
    private By continueShoppingButton = By.cssSelector("#continue-shopping");
    private By footer = By.cssSelector("footer");
    private By checkoutButton = By.cssSelector("[class$='checkout_button']");
    private By allButtonsOfCartPage = By.cssSelector("[class^='btn']");
    private By twitterLink = By.cssSelector(".social li:first-child");
    private By facebookLinkOnCartPage = By.cssSelector(".social li:nth-child(2)");
    private By linkedInLinkOnCartPage = By.cssSelector(".social li:nth-child(3)");

}

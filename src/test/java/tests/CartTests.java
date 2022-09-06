package tests;

import constants.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.services.LoginAsStandardUserService;
import utils.RetryAnalyzer;

@Log4j
public class CartTests extends BaseWithDriverFactoryTest {

    @BeforeMethod
    public void login() {
        log.info(String.format("Creating an instance of login service from %s and logging in as a standard user",
                LoginAsStandardUserService.class.getName()));
        LoginAsStandardUserService login = new LoginAsStandardUserService(driverManager.getDriver());
        login.loginAsStandardUser();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.BLOCKER)
    public void validateCartUrlAfterOpening() {
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info(String.format("Adding a product - onesie - to cart from Products page %s", ProductsPage.class.getName()));
        productsPage.addToCartOnesie();
        CartPage cartPage = new CartPage(driverManager.getDriver());
        log.info("Opening cart");
        cartPage.openCart();
        log.info("Saving current Url into a variable");
        String actualUrl = driverManager.getDriver().getCurrentUrl();
        log.info(String.format("Retrieving expected Url for Cart page from %s", Urls.SAUCEDEMO_CART_URL));
        String expectedUrl = Urls.SAUCEDEMO_CART_URL;
        Assert.assertEquals(actualUrl, expectedUrl, "Urls are not equal.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Test compares the price of onesie from products page to its price in shopping cart")
    @Severity(SeverityLevel.BLOCKER)
    public void validateOnesiePriceInCart() {
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info("Adding onesie to cart");
        productsPage.addToCartOnesie();
        log.info("Saving onesie's price into a variable");
        double priceOfOnesie = productsPage.getOnesiePrice();
        CartPage cartPage = new CartPage(driverManager.getDriver());
        log.info("Opening cart");
        cartPage.openCart();
        log.info("Saving onesie's price into another variable");
        double priceOfOnesieInCart = cartPage.getOnesiePriceInCart();
        log.info("Comparing onesie's price from Products and Cart pages");
        Assert.assertTrue(priceOfOnesie == priceOfOnesieInCart,
                "Prices don't match.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User attempts to remove item - onesie - from cart")
    @Severity(SeverityLevel.BLOCKER)
    public void removeOnesieFromCart() {
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info("Adding Onesie to cart from Products page");
        productsPage.addToCartOnesie();
        CartPage cartPage = new CartPage(driverManager.getDriver());
        log.info("Opening cart");
        cartPage.openCart();
        log.info("Removing onesie from cart");
        cartPage.removeOnesieFromCart();
        log.info("Clicking on Continue shopping button on Cart page");
        cartPage.continueShopping();
        log.info("Validating that onesie's button text reads as 'Add to cart' after returning back to Products page");
        Assert.assertTrue(productsPage.validateTextFromButton(), "Invalid button text.");
    }
}

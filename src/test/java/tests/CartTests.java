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
public class CartTests extends BaseWithThreadLocalManagerTest {

    @BeforeMethod
    public void login() {
        log.info(String.format("Opening Url %s after launching the browser", Urls.SAUCEDEMO_LOGIN_URL));
        driverManager.getDriver().get(Urls.SAUCEDEMO_LOGIN_URL);
        log.info(String.format("Creating an instance of login service from %s and logging in as a standard user",
                LoginAsStandardUserService.class.getName()));
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driverManager.getDriver());
        loginAsStandardUserService.loginAsStandardUser();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.BLOCKER)
    public void validateCartUrlAfterOpening() {
        log.info(String.format("Creating an instance of CartPage"));
        CartPage cartPage = new CartPage(driverManager.getDriver());
        log.info(String.format("Adding a product - onesie - to cart from Products page %s", ProductsPage.class.getName()));
        cartPage.addSingleProductToCart();
        log.info(String.format("Opening cart"));
        cartPage.openCart();
        log.info(String.format("Saving current Url into a variable"));
        String actualUrl = driverManager.getDriver().getCurrentUrl();
        log.info(String.format("Retrieving expected Url for Cart page from %s", Urls.SAUCEDEMO_CART_URL));
        String expectedUrl = Urls.SAUCEDEMO_CART_URL;
        log.info(String.format("Comparing actual Url to expected"));
        Assert.assertEquals(actualUrl, expectedUrl, "Urls are not equal.");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Test compares the price of onesie from products page to its price in shopping cart")
    @Severity(SeverityLevel.BLOCKER)
    public void validateOnesiePriceInCart() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info(String.format("Saving onesie's price into a variable"));
        double priceOfOnesie = productsPage.getOnesiePrice();
        log.info(String.format("Creating an instance of CartPage"));
        CartPage cartPage = new CartPage(driverManager.getDriver());
        log.info(String.format("Adding onesie to cart and opening cart"));
        cartPage.addSingleProductToCart();
        cartPage.openCart();
        log.info(String.format("Saving onesie's price into another variable"));
        double priceOfOnesieInCart = cartPage.getOnesiePriceInCart();
        log.info(String.format("Comparing onesie's price from Products and Cart pages"));
        Assert.assertTrue(priceOfOnesie == priceOfOnesieInCart,
                "Prices don't match.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Description("User attempts to remove item - onesie - from cart")
    @Severity(SeverityLevel.BLOCKER)
    public void removeOnesieFromCart() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info(String.format("Adding Onesie to cart from Products page"));
        productsPage.addToCartOnesie();
        log.info(String.format("Creating an instance of Cart page %s", CartPage.class.getName()));
        CartPage cartPage = new CartPage(driverManager.getDriver());
        log.info(String.format("Opening cart"));
        cartPage.openCart();
        log.info(String.format("Removing onesie from cart"));
        cartPage.removeOnesieFromCart();
        log.info(String.format("Clicking on Continue shopping button on Cart page"));
        cartPage.continueShopping();
        log.info(String.format("Validating that onesie's button text reads as 'Add to cart' after returning back to Products page"));
        Assert.assertTrue(productsPage.validateTextFromButton());
    }
}

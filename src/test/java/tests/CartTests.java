package tests;

import constants.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.services.AddProductToCartService;
import pages.services.LoginAsStandardUserService;
import utils.RetryAnalyzer;


public class CartTests extends BaseWithThreadLocalManagerTest {
    @BeforeMethod
    public void login() {
        driverManager.getDriver().get(Urls.SAUCEDEMO_LOGIN_URL);
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driverManager.getDriver());
        loginAsStandardUserService.loginAsStandardUser();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void validateCartUrlAfterOpening() {
        AddProductToCartService addProductToCartService = new AddProductToCartService(driverManager.getDriver());
        addProductToCartService.addSingleProductToCart();
        CartPage cartPage = new CartPage(driverManager.getDriver());
        cartPage.openCart();
        String actualUrl = driverManager.getDriver().getCurrentUrl();
        String expectedUrl = Urls.SAUCEDEMO_CART_URL;

        Assert.assertEquals(actualUrl, expectedUrl, "Urls are not equal.");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Test compares price of onesie from products page to its price after adding item to cart")
    @Severity(SeverityLevel.BLOCKER)
    public void validateOnesiePriceInCart() {
        //Saves onesie's price into a variable
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        double priceOfOnesie = productsPage.getOnesiePrice();

        //Adds onesie to cart and go to cart
        AddProductToCartService addProductToCartService = new AddProductToCartService(driverManager.getDriver());
        addProductToCartService.addSingleProductToCart();
        CartPage cartPage = new CartPage(driverManager.getDriver());
        cartPage.openCart();

        //Saves onesie's price into another variable
        double priceOfOnesieInCart = cartPage.getOnesiePriceInCart();

        //Compares prices from the Products page and from the Cart page
        Assert.assertTrue(priceOfOnesie == priceOfOnesieInCart,
                "Prices don't match.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Description("User attempts to remove item - onesie - from cart")
    @Severity(SeverityLevel.BLOCKER)
    public void removeOnesieFromCart() {
        CartPage cartPage = new CartPage(driverManager.getDriver());
        cartPage.openCart();
        cartPage.removeOnesieFromCart();
        cartPage.continueShopping();
    }
}

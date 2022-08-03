package tests;

import constants.Urls;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.services.AddProductToCartService;
import pages.services.LoginAsStandardUserService;

public class CartTests extends BaseWithFactoryTest {
    @BeforeMethod
    public void login() {
        driver.get(Urls.SAUCEDEMO_LOGIN_URL);
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        loginAsStandardUserService.loginAsStandardUser();
    }

    @Test(priority = 1)
    public void validateCartUrlAfterOpening() {
        AddProductToCartService addProductToCartService = new AddProductToCartService(driver);
        addProductToCartService.addSingleProductToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = Urls.SAUCEDEMO_CART_URL;

        Assert.assertEquals(actualUrl, expectedUrl, "Urls are not equal.");
    }

    @Test(priority = 2)
    public void validateOnesiePriceInCart() {
        //Save onesie's price into a variable
        ProductsPage productsPage = new ProductsPage(driver);
        double priceOfOnesie = productsPage.getOnesiePrice();

        //Add onesie to cart and go to cart
        AddProductToCartService addProductToCartService = new AddProductToCartService(driver);
        addProductToCartService.addSingleProductToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        //Save onesie's price into another variable
        double priceOfOnesieInCart = cartPage.getOnesiePriceInCart();

        //Compare prices from the Products page and from the Cart page
        Assert.assertTrue(priceOfOnesie == priceOfOnesieInCart,
                "Prices don't match.");
    }

    @Test(priority = 2)
    public void removeOnesieFromCart() {
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.removeOnesieFromCart();
        cartPage.continueShopping();
    }
}

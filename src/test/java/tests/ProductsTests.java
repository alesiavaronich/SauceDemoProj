package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.services.LoginAsStandardUserService;
import utils.RetryAnalyzer;

@Log4j
public class ProductsTests extends BaseWithDriverFactoryTest{

    @BeforeMethod
    public void login() {
        log.info(String.format("Creating an instance of login service from %s and logging in as a standard user",
                LoginAsStandardUserService.class.getName()));
        LoginAsStandardUserService login = new LoginAsStandardUserService(driverManager.getDriver());
        login.loginAsStandardUser();
    }

    @Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Test is checking whether shopping cart is empty")
    public void isShoppingCartEmpty() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.debug("Saving results of cart check into a boolean variable isCartEmpty");
        boolean isCartEmpty = productsPage.isShoppingCartEmpty();
        int cartItemCount = productsPage.getItemCountFromShoppingCart();
        log.debug(String.format("Number of items placed to cart: %s", cartItemCount));
        log.info("Creating an assertion with assertFalse");
        Assert.assertFalse((isCartEmpty), "ERROR! Cart is not empty.");
    }

    @Test(priority=2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Adding a single product to the cart - ONESIE")
    @Severity(SeverityLevel.BLOCKER)
    public void addSingleProductToCart() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info("Adding onesie to cart");
        productsPage.addToCartOnesie();
        log.info("Saving item count into a variable");
        int numOfItemsInCart = productsPage.getItemCountFromShoppingCart();
        log.info(String.format("Number of items placed to cart: %s", numOfItemsInCart));
        Assert.assertTrue((numOfItemsInCart == 1), "ERROR! Incorrect number of items in the cart.");
    }

    @Test(priority=3, retryAnalyzer = RetryAnalyzer.class)
    @Description("Adding two products to the cart - ONESIE & FLEECE JACKET")
    @Severity(SeverityLevel.BLOCKER)
    public void addSecondProductToCart() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info("Adding onesie and fleece jacket to cart");
        productsPage.addToCartOnesie();
        productsPage.addToCartFleeceJacket();
        int numOfItemsInCart = productsPage.getItemCountFromShoppingCart();
        log.debug(String.format("Number of items placed to cart: %s", numOfItemsInCart));
        Assert.assertTrue((numOfItemsInCart == 2), "ERROR! Incorrect number of items in the cart.");
    }

    @Test(priority=4, retryAnalyzer = RetryAnalyzer.class)
    @Description("Removing one of the products from the cart - FLEECE JACKET")
    @Severity(SeverityLevel.BLOCKER)
    public void removeSecondProductFromCart() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.info("Adding onesie and fleece jacket to cart");
        productsPage.addToCartOnesie();
        productsPage.addToCartFleeceJacket();
        log.info("Removing fleece jacket from cart");
        productsPage.removeFleeceJacketFromCart();
        int numOfItemsInCart = productsPage.getItemCountFromShoppingCart();
        log.debug(String.format("Number of items placed to cart: %s", numOfItemsInCart));
        Assert.assertTrue((numOfItemsInCart == 1), "ERROR! Incorrect number of items in the cart.");
    }

    @Test(priority=5, retryAnalyzer = RetryAnalyzer.class)
    @Description("Validating product's price comparing Products and Cart pages")
    @Severity(SeverityLevel.BLOCKER)
    public void isOnesiePriceCorrect() {
        log.info(String.format("Creating an instance of Products page %s", ProductsPage.class.getName()));
        ProductsPage productsPage = new ProductsPage(driverManager.getDriver());
        log.debug(String.format("Retrieving onesie's price from %s", ProductsPage.class.getName()));
        double actualPriceOnesie = productsPage.getOnesiePrice();
        log.debug(String.format("Price of onesie is %s", actualPriceOnesie));
        log.info("Saving onesie's expected price into a variable");
        double expectedPriceOnesie = 7.99;
        Assert.assertEquals(actualPriceOnesie, expectedPriceOnesie, "Prices do not match.");
    }
}

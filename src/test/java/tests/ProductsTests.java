package tests;

import constants.Urls;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.services.LoginAsStandardUserService;

public class ProductsTests extends BaseWithDriverFactoryTest {
    @BeforeMethod
    public void login() {
        driver.get(Urls.SAUCEDEMO_LOGIN_URL);
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        loginAsStandardUserService.loginAsStandardUser();
    }

    //Checking whether the shopping cart is empty
    //Please, help me with the logic of this test's assertion.
    @Test(priority = 1)
    public void isShoppingCartEmpty() {
        ProductsPage productsPage = new ProductsPage(driver);
        boolean isCartEmpty = productsPage.isShoppingCartEmpty();
        System.out.println("Number of items placed to cart: " + isCartEmpty);
        Assert.assertFalse((isCartEmpty), "ERROR! Cart is not empty.");
    }

    //Adding a single product to the cart - ONESIE
    @Test(priority = 2)
    public void addSingleProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartOnesie();

        int numOfItemsInCart = productsPage.getItemCountFromShoppingCart();
        System.out.println("Number of items placed to cart: " + numOfItemsInCart);
        Assert.assertTrue((numOfItemsInCart == 1), "ERROR! Incorrect number of items in the cart.");
    }

    //Adding second product to the cart - FLEECE JACKET
    @Test(priority = 3)
    public void addSecondProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartFleeceJacket();

        int numOfItemsInCart = productsPage.getItemCountFromShoppingCart();
        System.out.println("Number of items placed to cart: " + numOfItemsInCart);
        Assert.assertTrue((numOfItemsInCart == 2), "ERROR! Incorrect number of items in the cart.");
    }

    //Removing second product from the cart - FLEECE JACKET
    //IMPORTANT! Test 'removeSecondProductFromCart' depends on test 'addSecondProductToCart'
    @Test(priority = 4)
    public void removeSecondProductFromCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.removeFleeceJacketFromCart();

        int numOfItemsInCart = productsPage.getItemCountFromShoppingCart();
        System.out.println("Number of items placed to cart: " + numOfItemsInCart);
        Assert.assertTrue((numOfItemsInCart == 1), "ERROR! Incorrect number of items in the cart.");
    }

    @Test(priority = 5)
    public void isOnesiePriceCorrect() {
        ProductsPage productsPage = new ProductsPage(driver);
        double actualPriceOnesie = productsPage.getOnesiePrice();
        double expectedPriceOnesie = 7.99;
        System.out.println("Price of onesie is: " + actualPriceOnesie);
        Assert.assertEquals(actualPriceOnesie, expectedPriceOnesie, "Price does not match.");
    }
}

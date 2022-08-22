package tests;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpages.LoginFluentPage;
import pages.fluentpages.ProductsFluentPage;
import utils.RetryAnalyzer;

public class LoginWithFluentTest extends BaseWithDriverFactoryTest {

    public static final Logger LOGGER = LogManager.getLogger(LoginWithFluentTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUser() {
        LoginFluentPage loginFluentPage = new LoginFluentPage(driver);
        LOGGER.info(String.format("Page %s was initialized", LoginFluentPage.class.getName()));
        LOGGER.info(String.format("Saving a chain of actions from fluent page %s into a boolean variable",
                LoginFluentPage.class.getName()));
        boolean isProductsDisplayed =
                loginFluentPage
                .enterUsername(Credentials.SAUCEDEMO_LOGIN_STANDARD_USER)
                .enterPassword(Credentials.SAUCEDEMO_PASSWORD)
                .clickLoginButton()
                .isProductsSpanTitleDisplayed();
        LOGGER.info(String.format("Assertion: Checking whether a <span> with page title from page %s is displayed after successful login",
                ProductsFluentPage.class.getName()));
        Assert.assertTrue(isProductsDisplayed);
    }


}


package tests;

import constants.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.services.LoginAsStandardUserService;

public class LoginTest extends BaseTestForLogin {

    @Test
    public void loginAsStandardUser() {
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        loginAsStandardUserService.loginAsStandardUser();
        String actualUrlAfterLogin = driver.getCurrentUrl();
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;

        Assert.assertTrue(actualUrlAfterLogin.equals(expectedUrlAfterLogin), "Urls are not equal.");
    }
}

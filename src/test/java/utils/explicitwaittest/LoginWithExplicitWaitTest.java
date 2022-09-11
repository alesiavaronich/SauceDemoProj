package utils.explicitwaittest;

import constants.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInPage;
import pages.LoginPage;
import pages.services.LoginAsStandardUserService;
import utils.RetryAnalyzer;

public class LoginWithExplicitWaitTest extends BaseNoArchitectureTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUser() {
        LoginAsStandardUserService login = new LoginAsStandardUserService(driver);
        login.loginAsStandardUser();
        String actualUrlAfterLogin = driver.getCurrentUrl();
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;
        Assert.assertEquals(actualUrlAfterLogin, expectedUrlAfterLogin, "Urls are not equal.");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void loginWithExplicitWait() {
        LoginAsStandardUserService login = new LoginAsStandardUserService(driver);
        LoginPage loginPage = new LoginPage(driver);
        LinkedInPage linkedInPage = new LinkedInPage(driver);
        login.loginAsStandardUser();
        removeImplicitlyWait();
        loginPage.clickLinkedInLink();
        linkedInPage.setExplicitWaitOnLinkedInLogo();
        setImplicitlyWait();
        Assert.assertTrue(linkedInPage.returnLinkedInLogo().isDisplayed());
    }
}

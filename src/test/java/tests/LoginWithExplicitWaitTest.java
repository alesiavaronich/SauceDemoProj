package tests;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInPage;
import pages.LoginPage;
import pages.services.LoginAsStandardUserService;
import utils.RetryAnalyzer;

public class LoginWithExplicitWaitTest extends BaseNoArchitectureTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUser() {
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        loginAsStandardUserService.loginAsStandardUser();
        String actualUrlAfterLogin = driver.getCurrentUrl();
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;
        Assert.assertEquals(actualUrlAfterLogin, expectedUrlAfterLogin, "Urls are not equal.");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUserWithExplicitWait() {
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        LoginPage loginPage = new LoginPage(driver);
        LinkedInPage linkedInPage = new LinkedInPage(driver);

        loginAsStandardUserService.loginAsStandardUser();
        removeImplicitlyWait();
        loginPage.clickLinkedInLink();

        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//icon[@data-test-id='nav-logo']")));
        setImplicitlyWait();

        Assert.assertTrue(linkedInPage.returnLinkedInLogo().isDisplayed());
    }
}

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

public class LoginWithFactoryTest extends BaseTest {

    @Test(priority = 1)
    public void loginAsStandardUser() {
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        loginAsStandardUserService.loginAsStandardUser();
        String actualUrlAfterLogin = driver.getCurrentUrl();
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;
        Assert.assertEquals(actualUrlAfterLogin, expectedUrlAfterLogin, "Urls are not equal.");
    }

    @Test(priority = 2)
    public void loginAsStandardUserWithExplicitWait() {
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        LoginPage loginPage = new LoginPage(driver);
        LinkedInPage linkedInPage = new LinkedInPage(driver);

        loginAsStandardUserService.loginAsStandardUser();
        removeImplicitlyWait();
        loginPage.clickLinkedInLink();

        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//icon[@data-test-id='nav-logo']"))); // test passes
        //wait.until(ExpectedConditions.visibilityOf(linkedInPage.returnLinkedInLogo())); // test fails, doesn't find element HELP!
        setImplicitlyWait();

        Assert.assertTrue(linkedInPage.returnLinkedInLogo().isDisplayed());
    }
}

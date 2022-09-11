package tests;

import constants.Urls;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import models.SignInWithLombokBuilderModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.PrepareSignInData;
import utils.RetryAnalyzer;

@Log4j
public class LoginWithBuilderLombokModelTest extends BaseWithDriverFactoryTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        log.debug(String.format("Creating an instance of %s and building a standard user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel standardUserSignIn = new PrepareSignInData().getStandardUser();
        log.info("Sending login data for standard user");
        loginPage.enterUsername(standardUserSignIn.getUsername());
        log.info("Sending password data for standard user");
        loginPage.enterPassword(standardUserSignIn.getPassword());
        log.info(String.format("Clicking on Login button described on %s", LoginPage.class.getName()));
        loginPage.clickLoginButton();
        log.debug("Retrieving current Url after logging in as a standard user");
        String actualUrlAfterLogin = driver.getCurrentUrl();
        log.debug(String.format("Retrieving expected Url for Product page from %s", Urls.class.getName()));
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;
        log.debug("Comparing actual to expected results");
        Assert.assertEquals(actualUrlAfterLogin, expectedUrlAfterLogin, "Urls are not equal.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        log.debug(String.format("Creating an instance of %s and building a locked out user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        loginPage.enterUsername(lockedOutUserSignIn.getUsername());
        loginPage.enterPassword(lockedOutUserSignIn.getPassword());
        loginPage.clickLoginButton();
        String actualErrorMessage = loginPage.readErrorMessage();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message or no message.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Expected message was altered to test screenshots attachment on failure for Allure reports")
    public void loginAsLockedOutUserNegative() {
        LoginPage loginPage = new LoginPage(driver);
        log.debug(String.format("Creating an instance of %s and building a locked out user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        loginPage.enterUsername(lockedOutUserSignIn.getUsername());
        loginPage.enterPassword(lockedOutUserSignIn.getPassword());
        loginPage.clickLoginButton();
        String actualErrorMessage = loginPage.readErrorMessage();
        String expectedErrorMessage = "FAIL! Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message or no message.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        log.debug(String.format("Creating an instance of %s and building a problem user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel problemUserSignIn = new PrepareSignInData().getProblemUser();
        loginPage.enterUsername(problemUserSignIn.getUsername());
        loginPage.enterPassword(problemUserSignIn.getPassword());
        loginPage.clickLoginButton();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        log.debug(String.format("Creating an instance of %s and building a performance glitch user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel performanceGlitchUserSignIn = new PrepareSignInData().getPerformanceGlitchUser();
        loginPage.enterUsername(performanceGlitchUserSignIn.getUsername());
        loginPage.enterPassword(performanceGlitchUserSignIn.getPassword());
        loginPage.clickLoginButton();
    }
}


package tests;

import constants.Urls;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j;
import models.SignInWithLombokBuilderModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.PrepareSignInData;
import utils.RetryAnalyzer;

@Log4j
public class LoginWithBuilderLombokModelTest extends BaseWithDriverFactoryTest{

    @BeforeMethod
    public LoginPage getLoginPage() {
        log.info(String.format("Creating a new instance of %s page before each test method", LoginPage.class.getName()));
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUser() {
        log.debug(String.format("Creating an instance of %s and building a standard user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel standardUserSignIn = new PrepareSignInData().getStandardUser();
        log.info(String.format("Sending login data for standard user"));
        getLoginPage().enterUsername(standardUserSignIn.getUsername());
        log.info(String.format("Sending password data for standard user"));
        getLoginPage().enterPassword(standardUserSignIn.getPassword());
        log.info(String.format("Clicking on Login button described on %s", LoginPage.class.getName()));
        getLoginPage().clickLoginButton();
        log.debug(String.format("Retrieving current Url after logging in as a standard user"));
        String actualUrlAfterLogin = driver.getCurrentUrl();
        log.debug(String.format("Retrieving expected Url for Product page from %s", Urls.class.getName()));
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;
        log.debug(String.format("Comparing actual to expected results"));
        Assert.assertEquals(actualUrlAfterLogin, expectedUrlAfterLogin, "Urls are not equal.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsLockedOutUser() {
        log.debug(String.format("Creating an instance of %s and building a locked out user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        getLoginPage().enterUsername(lockedOutUserSignIn.getUsername());
        getLoginPage().enterPassword(lockedOutUserSignIn.getPassword());
        getLoginPage().clickLoginButton();

        Assert.assertTrue(getLoginPage().isErrorMessageVisible());

        String actualErrorMessage = getLoginPage().readErrorMessage();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message or no message.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Expected message was altered to test screenshots attachment on failure for Allure reports")
    public void loginAsLockedOutUserNegative() {
        log.debug(String.format("Creating an instance of %s and building a locked out user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        getLoginPage().enterUsername(lockedOutUserSignIn.getUsername());
        getLoginPage().enterPassword(lockedOutUserSignIn.getPassword());
        getLoginPage().clickLoginButton();

        Assert.assertTrue(getLoginPage().isErrorMessageVisible());

        String actualErrorMessage = getLoginPage().readErrorMessage();
        String expectedErrorMessage = "FAIL! Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message or no message.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsProblemUser() {
        log.debug(String.format("Creating an instance of %s and building a problem user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel problemUserSignIn = new PrepareSignInData().getProblemUser();
        getLoginPage().enterUsername(problemUserSignIn.getUsername());
        getLoginPage().enterPassword(problemUserSignIn.getPassword());
        getLoginPage().clickLoginButton();
        //Need help with assert here
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsPerformanceGlitchUser() {
        log.debug(String.format("Creating an instance of %s and building a performance glitch user sign-in using %s",
                SignInWithLombokBuilderModel.class.getName(),
                PrepareSignInData.class.getName()));
        SignInWithLombokBuilderModel performanceGlitchUserSignIn = new PrepareSignInData().getPerformanceGlitchUser();
        getLoginPage().enterUsername(performanceGlitchUserSignIn.getUsername());
        getLoginPage().enterPassword(performanceGlitchUserSignIn.getPassword());
        getLoginPage().clickLoginButton();
        //Need help with assert here
    }
}


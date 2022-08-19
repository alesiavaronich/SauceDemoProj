package tests;

import constants.Urls;
import io.qameta.allure.Description;
import models.SignInWithLombokBuilderModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.PrepareSignInData;
import utils.RetryAnalyzer;

public class LoginWithBuilderLombokModelTest extends BaseWithDriverFactoryTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsStandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel standardUserSignIn = new PrepareSignInData().getStandardUser();
        loginPage.enterUsername(standardUserSignIn.getUsername());
        loginPage.enterPassword(standardUserSignIn.getPassword());
        loginPage.clickLoginButton();

        String actualUrlAfterLogin = driver.getCurrentUrl();
        String expectedUrlAfterLogin = Urls.SAUCEDEMO_PRODUCT_URL;
        Assert.assertEquals(actualUrlAfterLogin, expectedUrlAfterLogin, "Urls are not equal.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        loginPage.enterUsername(lockedOutUserSignIn.getUsername());
        loginPage.enterPassword(lockedOutUserSignIn.getPassword());
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageVisible());

        String actualErrorMessage = loginPage.readErrorMessage();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message or no message.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Expected message was altered to test screenshots attachment on failure for Allure reports")
    public void loginAsLockedOutUserNegative() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        loginPage.enterUsername(lockedOutUserSignIn.getUsername());
        loginPage.enterPassword(lockedOutUserSignIn.getPassword());
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageVisible());

        String actualErrorMessage = loginPage.readErrorMessage();
        String expectedErrorMessage = "FAIL! Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message or no message.");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel problemUserSignIn = new PrepareSignInData().getProblemUser();
        loginPage.enterUsername(problemUserSignIn.getUsername());
        loginPage.enterPassword(problemUserSignIn.getPassword());
        loginPage.clickLoginButton();

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginAsPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel performanceGlitchUserSignIn = new PrepareSignInData().getPerformanceGlitchUser();
        loginPage.enterUsername(performanceGlitchUserSignIn.getUsername());
        loginPage.enterPassword(performanceGlitchUserSignIn.getPassword());
        loginPage.clickLoginButton();


    }
}


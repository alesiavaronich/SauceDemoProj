package tests;

import constants.Urls;
import models.SignInWithLombokBuilderModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.PrepareSignInData;

public class LoginWithBuilderLombokModelTest extends BaseWithDriverFactoryTest {

    @Test
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

    @Test
    public void loginAsLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel lockedOutUserSignIn = new PrepareSignInData().getLockedOutUser();
        loginPage.enterUsername(lockedOutUserSignIn.getUsername());
        loginPage.enterPassword(lockedOutUserSignIn.getPassword());
        loginPage.clickLoginButton();

        //to-do: add assertion
    }

    @Test
    public void loginAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel problemUserSignIn = new PrepareSignInData().getProblemUser();
        loginPage.enterUsername(problemUserSignIn.getUsername());
        loginPage.enterPassword(problemUserSignIn.getPassword());
        loginPage.clickLoginButton();

        //to-do: add assertion
    }

    @Test
    public void loginAsPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignInWithLombokBuilderModel performanceGlitchUserSignIn = new PrepareSignInData().getPerformanceGlitchUser();
        loginPage.enterUsername(performanceGlitchUserSignIn.getUsername());
        loginPage.enterPassword(performanceGlitchUserSignIn.getPassword());
        loginPage.clickLoginButton();

        //to-do: add assertion
    }


}

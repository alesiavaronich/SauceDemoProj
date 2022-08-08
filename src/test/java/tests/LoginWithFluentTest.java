package tests;

import constants.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fluentpages.LoginFluentPage;

public class LoginWithFluentTest extends BaseWithDriverFactoryTest {

    @Test
    public void loginAsStandardUser() {
        LoginFluentPage loginFluentPage = new LoginFluentPage(driver);
        boolean isProductsDisplayed =
                loginFluentPage
                .enterUsername(Credentials.SAUCEDEMO_LOGIN_STANDARD_USER)
                .enterPassword(Credentials.SAUCEDEMO_PASSWORD)
                .clickLoginButton()
                .isProductsSpanTitleDisplayed();
        Assert.assertTrue(isProductsDisplayed);
    }


}

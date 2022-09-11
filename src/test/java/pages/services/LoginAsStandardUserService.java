package pages.services;

import constants.Credentials;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import tests.BaseWithDriverFactoryTest;

public class LoginAsStandardUserService extends BaseWithDriverFactoryTest {

    private WebDriver driver;

    public LoginAsStandardUserService(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAsStandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(Credentials.SAUCEDEMO_LOGIN_STANDARD_USER);
        loginPage.enterPassword(Credentials.SAUCEDEMO_PASSWORD);
        loginPage.clickLoginButton();
    }
}

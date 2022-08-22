package pages;

import constants.Credentials;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class LoginPage extends BasePage {

    private By pageTitle = By.tagName("title"); //Swag Labs
    private By username = By.cssSelector("[data-test='username']");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("[data-test='login-button']");
    private By linkedInLink = By.xpath("//li[@class='social_linkedin']/a");
    private By errorMessageContainer = By.xpath("//form//div[@class='error-message-container error']/h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String text) {
        log.info(String.format("Looking for element: %s ; sending username from class %s", username, Credentials.class.getName()));
        driver.findElement(username).sendKeys(text);
    }

    public void enterPassword(String text) {
        log.info(String.format("Looking for element: %s; sending password from class %s", password, Credentials.class.getName()));
        driver.findElement(password).sendKeys(text);
    }

    public void clickLoginButton() {
        log.info(String.format("Triggering a click on Login button %s", loginButton));
        driver.findElement(loginButton).click();
    }

    public void clickLinkedInLink() {
        log.info(String.format("Looking for element: %s; clicking on LinkedIn link", linkedInLink));
        driver.findElement(linkedInLink).click();
    }

    public boolean isErrorMessageVisible() {
        log.debug(String.format("Validating whether error message is visible after clicking on Login button"));
        return driver.findElement(errorMessageContainer).isDisplayed();
    }

    public String readErrorMessage() {
        log.info(String.format("Reading an error message from error-message-container after clicking on Login button"));
        String errorMessage = driver.findElement(errorMessageContainer).getText();
        return errorMessage;
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(username).sendKeys(text);
    }

    public void enterPassword(String text) {
        driver.findElement(password).sendKeys(text);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLinkedInLink() {
        driver.findElement(linkedInLink).click();
    }

    public boolean isErrorMessageVisible() {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }

    public String readErrorMessage() {
        String errorMessage = driver.findElement(errorMessageContainer).getText();
        return errorMessage;
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private By pageTitle = By.tagName("title"); //Swag Labs
    private By username = By.cssSelector("[data-test='username']");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("[data-test='login-button']");

    public void setUsername(String text) {
        driver.findElement(username).sendKeys(text);
    }

    public void setPassword(String text) {
        driver.findElement(password).sendKeys(text);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


}

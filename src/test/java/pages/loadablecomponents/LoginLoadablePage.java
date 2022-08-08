package pages.loadablecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLoadablePage extends BaseLoadableComponent {

    private By pageTitle = By.tagName("title"); //Swag Labs
    private By username = By.cssSelector("[data-test='username']");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("[data-test='login-button']");
    private By linkedInLink = By.xpath("//li[@class='social_linkedin']/a");

    public LoginLoadablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return isLoginButtonDisplayed();
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

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }


}

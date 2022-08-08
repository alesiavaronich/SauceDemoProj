package pages.fluentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFluentPage extends BaseFluentPage {

    private By pageTitle = By.tagName("title"); //Swag Labs
    private By username = By.cssSelector("[data-test='username']");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("[data-test='login-button']");
    private By linkedInLink = By.xpath("//li[@class='social_linkedin']/a");

    public LoginFluentPage(WebDriver driver) {
        super(driver);
    }

    public LoginFluentPage enterUsername(String text) {
        driver.findElement(username).sendKeys(text);
        return this;
    }

    public LoginFluentPage enterPassword(String text) {
        driver.findElement(password).sendKeys(text);
        return this;
    }

    public ProductsFluentPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new ProductsFluentPage(driver);
    }

    public LinkedInFluentPage clickLinkedInLink() {
        driver.findElement(linkedInLink).click();
        return new LinkedInFluentPage(driver);
    }


}

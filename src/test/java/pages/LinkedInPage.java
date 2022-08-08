package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInPage extends BasePage {

    private By linkedInLogo = By.xpath("//icon[@data-test-id='nav-logo']");

    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement returnLinkedInLogo() {
        return driver.findElement(linkedInLogo);
    }
}
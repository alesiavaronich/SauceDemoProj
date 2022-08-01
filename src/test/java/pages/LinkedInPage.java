package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInPage {

    WebDriver driver;

    public LinkedInPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private By linkedInLogo = By.xpath("//icon[@data-test-id='nav-logo']");

    public WebElement returnLinkedInLogo() {
        return driver.findElement(linkedInLogo);
    }
}

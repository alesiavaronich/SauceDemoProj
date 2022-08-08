package pages.fluentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInFluentPage extends BaseFluentPage {

    private By linkedInLogo = By.xpath("//icon[@data-test-id='nav-logo']");

    public LinkedInFluentPage(WebDriver driver) {
        super(driver);
    }

    public WebElement returnLinkedInLogo() {
        return driver.findElement(linkedInLogo);
    }
}

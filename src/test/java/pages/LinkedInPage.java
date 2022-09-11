package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInPage extends BasePage {

    private By linkedInLogo = By.xpath("//icon[@data-test-id='nav-logo']");

    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement returnLinkedInLogo() {
        return driver.findElement(linkedInLogo);
    }

    public void setExplicitWaitOnLinkedInLogo() {
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkedInLogo));
    }
}

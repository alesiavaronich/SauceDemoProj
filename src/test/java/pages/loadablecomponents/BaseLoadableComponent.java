package pages.loadablecomponents;

import org.openqa.selenium.WebDriver;

public abstract class BaseLoadableComponent {

    public WebDriver driver;

    public BaseLoadableComponent(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isComponentDisplayed();
}

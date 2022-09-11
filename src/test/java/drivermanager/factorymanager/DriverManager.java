package drivermanager.factorymanager;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        return driver;
    }

    public void startMaximize() {
        driver.manage().window().maximize();
    }

    public void setTimeout() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        driver.quit();
    }
}

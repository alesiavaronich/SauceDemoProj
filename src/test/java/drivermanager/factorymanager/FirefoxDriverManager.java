package drivermanager.factorymanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyManager;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        String os = System.getProperty("os.name");
        String path = "PATH_TO_FIREFOX_WIN";
        if (!os.contains("Windows")) {
            path = "PATH_TO_FIREFOX_MAC";
        }
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.firefox.driver", propertyManager.get(path));
        driver = new FirefoxDriver();
    }
}

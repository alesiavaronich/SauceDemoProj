package drivermanager.factorymanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyManager;

public class ChromeDriverManager extends DriverManager{

    @Override
    public void createDriver() {
        String os = System.getProperty("os.name");
        String path = "PATH_TO_CHROME_WIN";
        if (!os.contains("Windows")) {
            path = "PATH_TO_CHROME_MAC";
        }
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.chrome.driver", propertyManager.get(path));
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
}

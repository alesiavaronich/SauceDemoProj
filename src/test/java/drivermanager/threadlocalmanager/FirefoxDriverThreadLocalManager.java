package drivermanager.threadlocalmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class FirefoxDriverThreadLocalManager extends DriverThreadLocalManager{

    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        // Is this correct for Firefox? See the code below. I've noticed that each driver/browser has a different set of options
        options.setCapability("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        threadLocalDriver.set(new FirefoxDriver(options));
    }
}

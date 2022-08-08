package drivermanager.factorymanager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager{

    @Override
    public void createDriver() {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "SauceDemo - LoginWithBuilderLombokModelTests");
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL("https://oauth-alesiavaronich-ca716:260bafea-d852-43ec-bdc6-c211102145aa@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

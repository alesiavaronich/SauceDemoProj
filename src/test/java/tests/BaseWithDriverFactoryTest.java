package tests;

import constants.Urls;
import drivermanager.factorymanager.DriverFactory;
import drivermanager.factorymanager.DriverManager;
import drivermanager.factorymanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListenersWithAllureService;

@Listeners(TestListenersWithAllureService.class)
public class BaseWithDriverFactoryTest {

    WebDriver driver;
    public DriverManager driverManager;


    @BeforeTest
    @Parameters({"browser"})
    public void setupDriver(@Optional("chrome") String browser) {
        DriverFactory driverFactory = new DriverFactory();
        DriverType type = null;
        if (browser.equals("chrome")) {
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            type = DriverType.FIREFOX;
        } else if (browser.equals("edge")) {
            type = DriverType.EDGE;
        } else if (browser.equals("remote")) {
            type = DriverType.REMOTE;
        }
        driverManager = driverFactory.getManager(type);
        driverManager.createDriver();
        driverManager.setTimeout();
        driverManager.startMaximize();
        driver = driverManager.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void openLoginUrl() {
        driver.get(Urls.SAUCEDEMO_LOGIN_URL);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }

}
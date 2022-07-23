package tests;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.services.LoginAsStandardUserService;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseTestForProducts {
    WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        String os = System.getProperty("os.name");
        String path = "PATH_TO_DRIVER_WIN";
        if (!os.contains("Windows")) {
            path = "PATH_TO_DRIVER_MAC";
        }
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.chrome.driver", propertyManager.get(path));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void login() {
        driver.get(Urls.SAUCEDEMO_LOGIN_URL);
        LoginAsStandardUserService loginAsStandardUserService = new LoginAsStandardUserService(driver);
        loginAsStandardUserService.loginAsStandardUser();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}

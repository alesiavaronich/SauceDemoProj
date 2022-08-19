package tests;

import drivermanager.factorymanager.DriverType;
import drivermanager.threadlocalmanager.DriverThreadLocalManager;
import drivermanager.threadlocalmanager.DriverThreadLocalManagerFactory;
import org.testng.annotations.*;

public class BaseWithThreadLocalManagerTest {

    DriverThreadLocalManager driverManager;

    @BeforeClass
    @Parameters({"browser"})
    public void createManager(@Optional("chrome") String browser) {
        DriverThreadLocalManagerFactory factory = new DriverThreadLocalManagerFactory();
        DriverType type = null;
        if (browser.equals("chrome")) {
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            type = DriverType.FIREFOX;
        }
        driverManager = factory.getManager(type);
    }

    @BeforeMethod
    public void setUp() {
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.getDriver().quit();
    }
}

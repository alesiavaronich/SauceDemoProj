package drivermanager.factorymanager;

public class DriverFactory {

    public DriverManager getManager(DriverType type) {
        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
            case EDGE:
                driverManager = new EdgeDriverManager();
            default:
                throw new IllegalStateException("Unexpected driver type" + type);
        }
        return driverManager;
    }


}

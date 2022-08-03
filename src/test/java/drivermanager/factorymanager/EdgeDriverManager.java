package drivermanager.factorymanager;

import org.openqa.selenium.edge.EdgeDriver;
import utils.PropertyManager;

public class EdgeDriverManager extends DriverManager{

    @Override
    public void createDriver() {
        String os = System.getProperty("os.name");
        String path = "PATH_TO_EDGE_WIN";
        if (!os.contains("Windows")) {
            path = "PATH_TO_EDGE_MAC";
        }
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.edge.driver", propertyManager.get(path));
        driver = new EdgeDriver();
    }
}

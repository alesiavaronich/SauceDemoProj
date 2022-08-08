package drivermanager.factorymanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{

    @Override
    public void createDriver() {
       WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
}

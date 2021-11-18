package frame_UI.driver;

import frame_UI.constants.PropertyConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final DriverManager INSTANCE = new DriverManager();

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static DriverManager getInstance() {
        return INSTANCE;
    }


    public DriverManager createWebDriver() {
        System.setProperty(PropertyConstants.CHROME_DRIVER, PropertyConstants.DRIVER_PATH);
        driver.set(new ChromeDriver());
        return this;
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}

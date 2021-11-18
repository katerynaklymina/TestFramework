package frame_UI.pages.selenium;

import frame_UI.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class PageObject {

    protected WebDriver driver = DriverManager.getInstance().getDriver();
}

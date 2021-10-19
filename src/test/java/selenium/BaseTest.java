package selenium;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static constants.HostConstants.AVIC_HOST;

public class BaseTest {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverManager.getInstance().createWebDriver().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);// ждем, пока прогрузится все страница
    }

    @BeforeMethod
    public void openTheLink(){
        driver.get(AVIC_HOST);
    }

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void close(){
        driver.close();
    }


}

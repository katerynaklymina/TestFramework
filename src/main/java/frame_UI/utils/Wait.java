package frame_UI.utils;

import frame_UI.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {

    private static WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(),20);

    public static void waitElementToBeClickable(WebElement el){
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public static void waitVisibilityOfElement(WebElement el){
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public static void waitVisibilityOfElementsList(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}

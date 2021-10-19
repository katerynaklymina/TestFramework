package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowHandler {

    public static void scrollToWebElement(WebElement element, int x, int y, WebDriver driver) {
        String code = "window.scroll(" + (element.getLocation().x + x) + "," + (element.getLocation().y + y) + ");";
        ((JavascriptExecutor) driver).executeScript(code, element, x, y);
    }
}

package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Properties;

public class Components {

    public static void clearAndEnter(WebDriver driver, By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Properties;

public class BaseUserPage {
    private final WebDriver driver;

    public BaseUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void menuSelectClick() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Properties.menu_select)));
        driver.findElement(By.cssSelector(Properties.menu_select)).click();
    }

    public void menuLkClick() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Properties.menu_lk)));
        driver.findElement(By.xpath(Properties.menu_lk)).click();
    }
}


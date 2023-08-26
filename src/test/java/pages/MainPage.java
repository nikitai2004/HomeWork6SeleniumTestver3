package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Properties;

import static components.Components.clearAndEnter;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {
        driver.get(Properties.url);
    }

    public void doLogIn() {
        driver.findElement(By.cssSelector(Properties.field_loginIn)).click();
    }

    public void enterLogin() {
        clearAndEnter(driver, By.xpath(Properties.field_email), Properties.login);
    }

    public void enterPass() {
        clearAndEnter(driver, By.xpath(Properties.field_pass), Properties.password);
    }

    public void doCommit() {
        driver.findElement(By.cssSelector(Properties.field_come_in)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(Properties.field_pass))));
    }
}
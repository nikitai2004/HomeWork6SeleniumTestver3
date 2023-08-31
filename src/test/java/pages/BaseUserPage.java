package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Properties;

public class BaseUserPage extends BasePage {

    public BaseUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sc-199a3eq-0")
    private WebElement menuSelect;

    @FindBy(xpath = "//*[text()='Мой профиль']")
    private WebElement menuClick;

    public void menuSelectClick() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(menuSelect));
        menuSelect.click();
    }

    public void menuLkClick() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(menuClick));
        menuClick.click();
    }
}


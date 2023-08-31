package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.PropertiesReader;

import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {
    private final Map<String, String> settings = new PropertiesReader().read();

    @FindBy(css = ".sc-mrx253-0")
    private WebElement doLogIn;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement enterLogin;

    @FindBy(xpath = "//input[@type=\'password\']")
    private WebElement enterPass;

    @FindBy(css = ".sc-11ptd2v-0>.sc-9a4spb-0")
    private WebElement commit;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openUrl() {
        driver.get(settings.get("url"));
    }

    public void doLogIn() {
        doLogIn.click();
    }

    public void enterLogin() {
        enterLogin.clear();
        enterLogin.sendKeys(settings.get("strlogin"));
    }

    public void enterPass() {
        enterPass.clear();
        enterPass.sendKeys(settings.get("strpassword"));
    }

    public void doCommit() {
        commit.click();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.invisibilityOf(enterPass));
    }
}
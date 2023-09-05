package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import settings.PropertiesReader;

import java.util.Map;

public class MainPage extends BasePage {
    private final Map<String, String> settings = new PropertiesReader().read();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openUrl() {
        driver.get(settings.get("url"));
    }

    @FindBy(css = ".sc-mrx253-0")
    private WebElement doLogIn;

    public void doLogIn() {
        doLogIn.click();
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement enterLogin;

    public void enterLogin() {
        enterLogin.clear();
        enterLogin.sendKeys(settings.get("strlogin"));
    }

    @FindBy(xpath = "//input[@type=\'password\']")
    private WebElement enterPass;

    public void enterPass() {
        enterPass.clear();
        enterPass.sendKeys(settings.get("strpassword"));
    }

    @FindBy(css = ".sc-11ptd2v-0>.sc-9a4spb-0")
    private WebElement commit;

    public void doCommit() {
        commit.click();
    }
}
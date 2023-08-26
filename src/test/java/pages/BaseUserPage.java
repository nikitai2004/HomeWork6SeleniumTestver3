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


//    private final Logger log = LogManager.getLogger(MainPage.class);
//
//    public static void openUrl(){ driver.get(Properties.url);
//    }
//    public static void doLogIn() { driver.findElement(By.cssSelector(Properties.field_loginIn)).click(); }
//
//    public static void enterLogin() {
//        clearAndEnter(driver, By.xpath(Properties.field_email), Properties.login);
//    }
//
//    public static void enterPass() {
//        clearAndEnter(driver, By.xpath(Properties.field_pass), Properties.password);
//    }
//
//    public static void doCommit() {
//        driver.findElement(By.cssSelector(Properties.field_come_in)).click();
//    }


//        new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(Properties.field_pass))));
//
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-199a3eq-0")));

//        driver.findElement(By.cssSelector(".sc-199a3eq-0")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Мой профиль']")));
//        driver.findElement(By.xpath("//*[text()='Мой профиль']")).click();
}


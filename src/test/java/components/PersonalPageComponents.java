package components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Properties;

import static components.Components.clearAndEnter;

public class PersonalPageComponents {
    private static final Logger log = LogManager.getLogger(PersonalPageComponents.class);

    public static void SelectRu(WebDriver driver) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOf(
                                driver.findElement(By.cssSelector(Properties.field_rus))));
        driver.findElement(By.cssSelector(Properties.field_rus)).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .invisibilityOf(
                                driver.findElement(By.cssSelector(Properties.field_rus))));
    }

    public static void SelectTown(WebDriver driver) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.
                        visibilityOf(
                                driver.findElement(By.xpath(Properties.field_town))));
        driver.findElement(By.xpath(Properties.field_town)).click();
    }

    public static void SelectSpb(WebDriver driver) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.
                        elementToBeClickable(
                                driver.findElement(By.cssSelector(Properties.field_spb))));
        driver.findElement(By.cssSelector(Properties.field_spb)).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .invisibilityOf(
                                driver.findElement(By.cssSelector(Properties.field_spb))));
    }

    static boolean isDisplayed(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void delContacts(WebDriver driver) {
        int i = 1;
        do {
            String s = Properties.delContacts1of2 + i + Properties.delContacts2of2;
            log.info("  Contacts for delete found  =  ");
            log.info(s);
            if (!isDisplayed(driver, By.cssSelector(s))) {
                break;
            } else {
                log.info("  isDispContact  =  ");
                log.info(isDisplayed(driver, By.cssSelector(s)));
                driver.findElement(By.cssSelector(s)).click();
            }
            i++;
        } while (i < 20);
    }

    public static void addContacts(WebDriver driver) {
        //add new contacts
        driver.findElement(By.xpath(Properties.link_conn)).click();
        driver.findElement(By.cssSelector(Properties.vk)).click();
        clearAndEnter(driver, By.id(Properties.vk_place), Properties.vk_string);
        driver.findElement(By.xpath(Properties.add_button)).click();
        driver.findElement(By.xpath(Properties.link_conn)).click();
        driver.findElement(By.cssSelector(Properties.ok)).click();
        clearAndEnter(driver, By.id(Properties.ok_place), Properties.ok_string);
        driver.findElement(By.xpath(Properties.add_button)).click();
        driver.findElement(By.xpath(Properties.link_conn)).click();
        driver.findElement(By.cssSelector(Properties.tlg)).click();
        clearAndEnter(driver, By.cssSelector(Properties.tlg_place), Properties.tlg_string);
        driver.findElement(By.xpath(Properties.add_button)).click();
        driver.findElement(By.xpath(Properties.link_conn)).click();
        driver.findElement(By.cssSelector(Properties.sk)).click();
        clearAndEnter(driver, By.cssSelector(Properties.sk_place), Properties.sk_string);
    }

    public static void delExperience(WebDriver driver) {
        int i = 1;
        do {
            String s = Properties.delExp1of2 + i + Properties.delExp2of2;
            log.info("  Experience for delete found  =  ");
            log.info(s);
            if (!isDisplayed(driver, By.cssSelector(s))) {
                break;
            } else {
                log.info("  isDispExperience  =  ");
                log.info(isDisplayed(driver, By.cssSelector(s)));
                driver.findElement(By.cssSelector(s)).click();
            }
            i++;
        } while (i < 20);
    }

    public static void addExperiences(WebDriver driver) {
        //  Добавим одну строку
        driver.findElement(By.cssSelector(Properties.field_add)).click();
        driver.findElement(By.cssSelector(Properties.field_add_1)).click();
        driver.findElement(By.cssSelector(Properties.field_add_1_java)).click();
        driver.findElement(By.cssSelector(Properties.field_add_1_time)).click();
        //  Добавим еще одну строку
        driver.findElement(By.cssSelector(Properties.field_add)).click();
        driver.findElement(By.cssSelector(Properties.field_add_2)).click();
        driver.findElement(By.cssSelector(Properties.field_add_2_perl)).click();
        driver.findElement(By.cssSelector(Properties.field_add_2_time)).click();
    }
}

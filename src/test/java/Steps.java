import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {
    private static final Logger log = LogManager.getLogger(HomeWork5SeleniumTest.class);

    static boolean isDisplayed(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    static void openOtus(WebDriver driver) {
        driver.get(Properties.url);
    }

    static void enterToLkab(WebDriver driver) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .invisibilityOf(
                                driver.findElement(By.xpath(Properties.field_pass))));
        driver.get(Properties.url_lk);
    }

    static void loginInOtus(WebDriver driver) {
        driver.findElement(By.cssSelector(Properties.field_loginIn)).click();
        clearAndEnter(driver, By.xpath(Properties.field_email), Properties.login);
        clearAndEnter(driver, By.xpath(Properties.field_pass), Properties.password);
        driver.findElement(By.cssSelector(Properties.field_come_in)).click();
    }

    private static void Ru(WebDriver driver) {
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

    private static void Spb(WebDriver driver) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.
                        visibilityOf(
                                driver.findElement(By.xpath(Properties.field_town))));
        driver.findElement(By.xpath(Properties.field_town)).click();
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

    static void fillLK(WebDriver driver) {
        // fio
        clearAndEnter(driver, By.id(Properties.field_fname), Properties.field_fname_string);
        clearAndEnter(driver, By.id(Properties.field_lname), Properties.field_lname_string);
        clearAndEnter(driver, By.id(Properties.field_fname_latin), Properties.field_fname_latin_string);
        clearAndEnter(driver, By.id(Properties.field_lname_latin), Properties.field_lname_latin_string);
        clearAndEnter(driver, By.name(Properties.field_date_of_birth), Properties.field_date_of_birth_string);
        driver.findElement(By.id(Properties.field_id_blog_name)).click();
        //выбор страны
        driver.findElement(By.xpath(Properties.field_country)).click();
        Ru(driver);
        clearAndEnter(driver, By.id(Properties.field_id_blog_name), Properties.field_id_blog_name_string);
        //выбор города
        Spb(driver);
        driver.findElement(By.id(Properties.field_id_blog_name)).click();
        //Уровень англ
        driver.findElement(By.xpath(Properties.field_eng_level)).click();
        driver.findElement(By.xpath(Properties.field_eng_adv)).click();
        //Готовность к переезду - включаем
        //=======System.out.println(" переезд isSelected = " + driver.findElement(By.xpath(Properties.field_reloc_yes)).isSelected());
        driver.findElement(By.xpath(Properties.field_reloc_yes)).click();
        // Полный день - проверяем, включаем, если выкл - но ЗАЛОЧЕНО
        driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected();
        //======System.out.println("selected full day = " + driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected());
        WebElement checkboxF = driver.findElement(By.cssSelector(Properties.field_full_day));
        if (!driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected()) {
            checkboxF.click();
        }

        // График - проверяем, если выкл - то включаем
        driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected();
        //=======System.out.println("selected Flex = " + driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected());
        WebElement checkboxFl = driver.findElement(By.cssSelector(Properties.field_flex));
        if (!driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected()) {
            checkboxFl.click();
        }

        // Удаленно - проверяем, если выкл - то включаем
        driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected();
        //=======System.out.println("selected Dist = " + driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected());
        WebElement checkboxD = driver.findElement(By.cssSelector(Properties.field_dist));
        if (!driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected()) {
            checkboxD.click();
        }

        // del Contacts
        delContacts(driver);

        // Add Contacts
        addContacts(driver);

        // Пол
        if (!(driver.findElement(By.cssSelector(Properties.field_s2)).isSelected())) {
            driver.findElement(By.cssSelector(Properties.field_s)).click();
            driver.findElement(By.cssSelector(Properties.field_s2)).click();
            // проверка (после сохранения!)
            // System.out.println(" isSelected 2 = " + driver.findElement(By.cssSelector(Properties.field_s2)).isSelected());
        }

        // Компания
        clearAndEnter(driver, By.id(Properties.field_comp), Properties.field_comp_name);

        //Должность
        clearAndEnter(driver, By.id(Properties.field_pos), Properties.field_pos_name);

        //   Удалим Опыт разработки, если есть
        delExperience(driver);
        //   Добавим Опыт разработки который хотели
        addExperiences(driver);

        //Save and open Personal Data again
        driver.findElement(By.cssSelector(Properties.field_save)).submit();
        driver.findElement(By.xpath(Properties.field_pers_data)).click();
    }

    private static void delExperience(WebDriver driver) {
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
        //save results and go back to site LK
        driver.findElement(By.cssSelector(Properties.field_save)).submit();
        driver.findElement(By.xpath(Properties.field_pers_data)).click();
    }

    private static void clearAndEnter(WebDriver driver, By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    private static void delContacts(WebDriver driver) {
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
        //save results and go back to site LK
        driver.findElement(By.cssSelector(Properties.field_save)).submit();
        driver.findElement(By.xpath(Properties.field_pers_data)).click();
    }

    private static void addContacts(WebDriver driver) {
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
        //save results and go back to site LK
        driver.findElement(By.cssSelector(Properties.field_save)).submit();
        driver.findElement(By.xpath(Properties.field_pers_data)).click();
    }

    private static void addExperiences(WebDriver driver) {
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
package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Properties;

import static components.PersonalPageComponents.clearAndEnter;

public class CheckPersonalData extends BasePage{

    public CheckPersonalData(WebDriver driver) {
        super(driver);
    }

    public void checkFName() {
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_fname)).getAttribute(Properties.val), Properties.field_fname_string);
    }

    public void checkFNameLatin() {
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_fname_latin)).getAttribute(Properties.val), Properties.field_fname_latin_string);
    }

    public void checkLName() {
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_lname)).getAttribute(Properties.val), Properties.field_lname_string);
    }

    public void checkLNameLatin() {
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_lname_latin)).getAttribute(Properties.val), Properties.field_lname_latin_string);
    }

    public void checkBlogName() {
     Assertions.assertEquals(driver.findElement(By.id(Properties.field_id_blog_name)).getAttribute(Properties.val), Properties.field_id_blog_name_string);
    }

    public void checkDateOfBirth() {
        Assertions.assertEquals(driver.findElement(By.name(Properties.field_date_of_birth)).getAttribute(Properties.val), Properties.field_date_of_birth_string);
    }

    public void checkCountry() {
        Assertions.assertEquals(driver.findElement(By.xpath(Properties.field_country)).getText(), Properties.field_rus_string);
    }

    public void checkTown() {
        Assertions.assertEquals(driver.findElement(By.xpath(Properties.field_town_load)).getText(), Properties.field_town_string);
    }

    public void checkEngLevel() {
        Assertions.assertEquals(driver.findElement(By.xpath(Properties.field_eng_level)).getText(), Properties.field_eng_level_string);
    }

    public void checkRelocation() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_reloc_yes_load)).isSelected());
    }

    public void checkFullDay() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected());
    }

    public void checkFlex() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected());
    }

    public void checkDist() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected());
    }

    public void checkEmail() {
        Assertions.assertEquals(driver.findElement(By.cssSelector(Properties.field_email_load)).getAttribute(Properties.val), Properties.login);
    }

    public void checkPhone() {
        Assertions.assertEquals(driver.findElement(By.cssSelector(Properties.field_phone)).getAttribute(Properties.val), Properties.phone);
    }

    public void checkVK() {
        Assertions.assertTrue(
                Properties.vk_string.equals(driver.findElement(By.id(Properties.val0)).getAttribute(Properties.val)) ||
                        Properties.vk_string.equals(driver.findElement(By.id(Properties.val1)).getAttribute(Properties.val)) ||
                        Properties.vk_string.equals(driver.findElement(By.id(Properties.val2)).getAttribute(Properties.val)) ||
                        Properties.vk_string.equals(driver.findElement(By.id(Properties.val3)).getAttribute(Properties.val)));
    }

    public void checkOK() {
        Assertions.assertTrue(
                Properties.ok_string.equals(driver.findElement(By.id(Properties.val0)).getAttribute(Properties.val)) ||
                        Properties.ok_string.equals(driver.findElement(By.id(Properties.val1)).getAttribute(Properties.val)) ||
                        Properties.ok_string.equals(driver.findElement(By.id(Properties.val2)).getAttribute(Properties.val)) ||
                        Properties.ok_string.equals(driver.findElement(By.id(Properties.val3)).getAttribute(Properties.val)));
    }

    public void checkTlg() {
        Assertions.assertTrue(
                Properties.tlg_string.equals(driver.findElement(By.id(Properties.val0)).getAttribute(Properties.val)) ||
                        Properties.tlg_string.equals(driver.findElement(By.id(Properties.val1)).getAttribute(Properties.val)) ||
                        Properties.tlg_string.equals(driver.findElement(By.id(Properties.val2)).getAttribute(Properties.val)) ||
                        Properties.tlg_string.equals(driver.findElement(By.id(Properties.val3)).getAttribute(Properties.val)));
    }

    public void checkSkype() {
        Assertions.assertTrue(
                Properties.sk_string.equals(driver.findElement(By.id(Properties.val0)).getAttribute(Properties.val)) ||
                        Properties.sk_string.equals(driver.findElement(By.id(Properties.val1)).getAttribute(Properties.val)) ||
                        Properties.sk_string.equals(driver.findElement(By.id(Properties.val2)).getAttribute(Properties.val)) ||
                        Properties.sk_string.equals(driver.findElement(By.id(Properties.val3)).getAttribute(Properties.val)));
    }

    public void checkSex() {
        Assertions.assertEquals(Properties.field_sm, driver.findElement(By.cssSelector(Properties.field_s2)).getAttribute(Properties.val));
        Assertions.assertTrue((driver.findElement(By.cssSelector(Properties.field_s2)).isSelected()));
    }

    public void checkCompany() {
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_comp)).getAttribute(Properties.val), Properties.field_comp_name);
    }

    public void checkPos() {
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_pos)).getAttribute(Properties.val), Properties.field_pos_name);
    }

    public void checkExperience() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_add_1_java)).isSelected());
        Assertions.assertEquals(Properties.field_add_1_time_string, driver.findElement(By.cssSelector(Properties.field_add_1_time)).getText());
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_add_2_perl)).isSelected());
        Assertions.assertEquals(Properties.field_add_2_time_string, driver.findElement(By.cssSelector(Properties.field_add_2_time)).getText());
    }
}
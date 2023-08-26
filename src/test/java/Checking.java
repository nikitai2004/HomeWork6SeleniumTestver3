import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Properties;

public class Checking {
    static void checkData(WebDriver driver) {
        // fio
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_fname)).getAttribute("value"), Properties.field_fname_string);
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_lname)).getAttribute("value"), Properties.field_lname_string);
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_fname_latin)).getAttribute("value"), Properties.field_fname_latin_string);
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_lname_latin)).getAttribute("value"), Properties.field_lname_latin_string);
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_id_blog_name)).getAttribute("value"), Properties.field_id_blog_name_string);
        Assertions.assertEquals(driver.findElement(By.name(Properties.field_date_of_birth)).getAttribute("value"), Properties.field_date_of_birth_string);
        // country, town, eng
        Assertions.assertEquals(driver.findElement(By.xpath(Properties.field_country)).getText(), Properties.field_rus_string);
        Assertions.assertEquals(driver.findElement(By.xpath(Properties.field_town_load)).getText(), Properties.field_town_string);
        Assertions.assertEquals(driver.findElement(By.xpath(Properties.field_eng_level)).getText(), Properties.field_eng_level_string);
        // relocation - radiobutton
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_reloc_yes_load)).isSelected());
        // full day
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected());
        // flex schedule
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected());
        // distant
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected());
        //  email
        Assertions.assertEquals(driver.findElement(By.cssSelector(Properties.field_email_load)).getAttribute("value"), Properties.login);
        //  phone
        Assertions.assertEquals(driver.findElement(By.cssSelector(Properties.field_phone)).getAttribute("value"), Properties.phone);

        //  vk
        Assertions.assertTrue(
                Properties.vk_string.equals(driver.findElement(By.id("id_contact-0-value")).getAttribute("value")) ||
                        Properties.vk_string.equals(driver.findElement(By.id("id_contact-1-value")).getAttribute("value")) ||
                        Properties.vk_string.equals(driver.findElement(By.id("id_contact-2-value")).getAttribute("value")) ||
                        Properties.vk_string.equals(driver.findElement(By.id("id_contact-3-value")).getAttribute("value")));
        //  ok
        Assertions.assertTrue(
                Properties.ok_string.equals(driver.findElement(By.id("id_contact-0-value")).getAttribute("value")) ||
                        Properties.ok_string.equals(driver.findElement(By.id("id_contact-1-value")).getAttribute("value")) ||
                        Properties.ok_string.equals(driver.findElement(By.id("id_contact-2-value")).getAttribute("value")) ||
                        Properties.ok_string.equals(driver.findElement(By.id("id_contact-3-value")).getAttribute("value")));
        //  tlg
        Assertions.assertTrue(
                Properties.tlg_string.equals(driver.findElement(By.id("id_contact-0-value")).getAttribute("value")) ||
                        Properties.tlg_string.equals(driver.findElement(By.id("id_contact-1-value")).getAttribute("value")) ||
                        Properties.tlg_string.equals(driver.findElement(By.id("id_contact-2-value")).getAttribute("value")) ||
                        Properties.tlg_string.equals(driver.findElement(By.id("id_contact-3-value")).getAttribute("value")));
        //  skype
        Assertions.assertTrue(
                Properties.sk_string.equals(driver.findElement(By.id("id_contact-0-value")).getAttribute("value")) ||
                        Properties.sk_string.equals(driver.findElement(By.id("id_contact-1-value")).getAttribute("value")) ||
                        Properties.sk_string.equals(driver.findElement(By.id("id_contact-2-value")).getAttribute("value")) ||
                        Properties.sk_string.equals(driver.findElement(By.id("id_contact-3-value")).getAttribute("value")));

        // пол
        Assertions.assertEquals(Properties.field_sm, driver.findElement(By.cssSelector(Properties.field_s2)).getAttribute("value"));
        Assertions.assertTrue((driver.findElement(By.cssSelector(Properties.field_s2)).isSelected()));
        //  company
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_comp)).getAttribute("value"), Properties.field_comp_name);
        //  position
        Assertions.assertEquals(driver.findElement(By.id(Properties.field_pos)).getAttribute("value"), Properties.field_pos_name);
        //  exp
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_add_1_java)).isSelected());
        Assertions.assertEquals(Properties.field_add_1_time_string, driver.findElement(By.cssSelector(Properties.field_add_1_time)).getText());
        Assertions.assertTrue(driver.findElement(By.cssSelector(Properties.field_add_2_perl)).isSelected());
        Assertions.assertEquals(Properties.field_add_2_time_string, driver.findElement(By.cssSelector(Properties.field_add_2_time)).getText());
    }
}

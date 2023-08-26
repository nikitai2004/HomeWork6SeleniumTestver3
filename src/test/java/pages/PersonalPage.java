package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.Properties;

import static components.PersonalPageComponents.*;

public class PersonalPage {
    private final WebDriver driver;

    public PersonalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFName() {
        clearAndEnter(driver, By.id(Properties.field_fname), Properties.field_fname_string);
    }

    public void enterLName() {
        clearAndEnter(driver, By.id(Properties.field_lname), Properties.field_lname_string);
    }

    public void enterFNameLatin() {
        clearAndEnter(driver, By.id(Properties.field_fname_latin), Properties.field_fname_latin_string);
    }

    public void enterLNameLatin() {
        clearAndEnter(driver, By.id(Properties.field_lname_latin), Properties.field_lname_latin_string);
    }

    public void enterDataOfBirth() {
        clearAndEnter(driver, By.name(Properties.field_date_of_birth), Properties.field_date_of_birth_string);
    }

    public void enterBlogName() {
        clearAndEnter(driver, By.id(Properties.field_id_blog_name), Properties.field_id_blog_name_string);
    }

    public void selectCountry() {
        driver.findElement(By.xpath(Properties.field_country)).click();
    }

    public void selectedCountryRu() {
        SelectRu(driver);
    }

    public void selectTown() {
        SelectTown(driver);
    }

    public void selectedSpb() {
        SelectSpb(driver);
    }

    public void selectEngLevel() {
        driver.findElement(By.xpath(Properties.field_eng_level)).click();
    }

    public void selectedEngLevelAdv() {
        driver.findElement(By.xpath(Properties.field_eng_adv)).click();
    }

    public void selectRelocation() {
        driver.findElement(By.xpath(Properties.field_reloc_yes)).click();
    }

    public void selectFullDay() {
        driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected();
        WebElement checkboxF = driver.findElement(By.cssSelector(Properties.field_full_day));
        if (!driver.findElement(By.cssSelector(Properties.field_full_day_load)).isSelected()) {
            checkboxF.click();
        }
    }

    public void selectFlex() {
        driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected();
        WebElement checkboxFl = driver.findElement(By.cssSelector(Properties.field_flex));
        if (!driver.findElement(By.cssSelector(Properties.field_flex_load)).isSelected()) {
            checkboxFl.click();
        }
    }

    public void selectDist() {
        driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected();
        WebElement checkboxD = driver.findElement(By.cssSelector(Properties.field_dist));
        if (!driver.findElement(By.cssSelector(Properties.field_dist_load)).isSelected()) {
            checkboxD.click();
        }
    }

    public void savePersonalPage() {
        driver.findElement(By.cssSelector(Properties.field_save)).submit();
    }

    public void fillContacts() {
        addContacts(driver);
    }

    public void deleteContacts() {
        delContacts(driver);
    }

    public void selectSexMale() {
        if (!(driver.findElement(By.cssSelector(Properties.field_s2)).isSelected())) {
            driver.findElement(By.cssSelector(Properties.field_s)).click();
            driver.findElement(By.cssSelector(Properties.field_s2)).click();
        }
    }

    public void enterCompany() {
        clearAndEnter(driver, By.id(Properties.field_comp), Properties.field_comp_name);
    }

    public void enterPosition() {
        clearAndEnter(driver, By.id(Properties.field_pos), Properties.field_pos_name);
    }

    public void deleteExperience() {
        delExperience(driver);
    }

    public void fillExperiences() {
        addExperiences(driver);
    }
}
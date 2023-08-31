package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Properties;

public class PersonalPage extends BasePage {
    private static final Logger log = LogManager.getLogger(PersonalPage.class);

    private final static String field_fname_string = "Алексей";
    private final static String field_lname_string = "Петров";
    private final static String field_fname_latin_string = "Alex";
    private final static String field_lname_latin_string = "Petroff";
    private final static String field_id_blog_name_string = "AlexPetroffBlog";
    private final static String field_date_of_birth_string = "12.05.2009";
    private final static String field_rus_string = "Россия";
    private final static String field_town_string = "Санкт-Петербург";
    private final static String field_eng_level_string = "Продвинутый (Advanced)";
    private final static String field_comp_name = "ООО \"ХОМЯЧКИ\"";
    private final static String field_pos_name = "Главный хомяк";
    private final static String delContacts1of2 = "div.js-formset-row:nth-child(";
    private final static String delContacts2of2 = ") > div:nth-child(4) > div:nth-child(2) > button:nth-child(1)";
    private final static String delExp1of2 = "div:nth-child(";
    private final static String delExp2of2 = ") > div.experience-row__remove.ic-close.js-formset-delete";
    private final static String vkString = "https://vk.ru/profile/132456";
    private final static String okString = "https://ok.ru/profile/846341";
    private final static String tlgString = "TELEGRAM:131853131";
    private final static String skString = "SKYPE:8431351313";
    private final static String field_add_1_time_string = "1 год";
    private final static String field_add_2_time_string = "2 года";
    private final static String val = "value";
    private final static String val0 = "id_contact-0-value";
    private final static String val1 = "id_contact-1-value";
    private final static String val2 = "id_contact-2-value";
    private final static String val3 = "id_contact-3-value";


    @FindBy(id = "id_fname")
    private WebElement enterFName;

    @FindBy(id = "id_lname")
    private WebElement enterLName;

    @FindBy(id = "id_fname_latin")
    private WebElement fieldFnameLatin;

    @FindBy(id = "id_lname_latin")
    private WebElement fieldLnameLatin;

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    public void enterFName() {
        enterFName.clear();
        enterFName.sendKeys(field_fname_string);
    }

    public void enterLName() {
        enterLName.clear();
        enterLName.sendKeys(field_lname_string);
    }

    public void enterFNameLatin() {
        fieldFnameLatin.clear();
        fieldFnameLatin.sendKeys(field_fname_latin_string);
    }

    public void enterLNameLatin() {
        fieldLnameLatin.clear();
        fieldLnameLatin.sendKeys(field_lname_latin_string);
    }

    @FindBy(name = "date_of_birth")
    private WebElement enterDataOfBirth;

    public void enterDataOfBirth() {
        enterDataOfBirth.clear();
        enterDataOfBirth.sendKeys(field_date_of_birth_string);
    }

    @FindBy(id = "id_blog_name")
    private WebElement enterBlogName;

    public void enterBlogName() {
        enterBlogName.clear();
        enterBlogName.sendKeys(field_id_blog_name_string);
    }

    @FindBy(xpath = "//div[@class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-dependent-master js-lk-cv-custom-select']//label//div[1]")
    private WebElement selectCountry;

    public void selectCountry() {
        selectCountry.click();
    }

    @FindBy(css = "button[title='Россия']")
    private WebElement selectedCountryRu;

    public void selectedCountryRu() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(selectedCountryRu));
        selectedCountryRu.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(selectedCountryRu));
    }

    @FindBy(xpath = "//div/span[@class='placeholder']")
    private WebElement selectTown;

    public void selectTown() {
       // new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(selectTown));
        selectTown.click();
    }

    @FindBy(css = "button[title='Санкт-Петербург']")
    private WebElement selectedSpb;

    public void selectedSpb() {
       // new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(selectedSpb));
        selectedSpb.click();
      //  new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(selectedSpb));
    }

    @FindBy(xpath = "//div[contains(@class,'select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select')]//label//div[1]")
    private WebElement selectEngLevel;

    public void selectEngLevel() {
        selectEngLevel.click();
    }

    @FindBy(xpath = "//button[contains(@title,'Продвинутый (Advanced)')]")
    private WebElement selectedEngLevelAdv;

    public void selectedEngLevelAdv() {
        selectedEngLevelAdv.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Да')]")
    private WebElement selectRelocation;

    public void selectRelocation() {
        selectRelocation.click();
    }

    @FindBy(css = "div:nth-child(1) > div:nth-child(2) > label > span")
    private WebElement selectFullDay;

    @FindBy(css = "input[title=\'Полный день\']")
    private WebElement selectFullDayLoad;

    public void selectFullDay() {
        selectFullDay.isSelected();
        if (!selectFullDayLoad.isSelected()) {
            selectFullDay.click();
        }
    }

    @FindBy(css = "div:nth-child(2) > div:nth-child(2) > label > span")
    private WebElement selectFlex;

    @FindBy(css = "input[title=\'Гибкий график\']")
    private WebElement selectFlexLoad;

    public void selectFlex() {
        selectFlex.isSelected();
        if (!selectFlexLoad.isSelected()) {
            selectFlex.click();
        }
    }

    @FindBy(css = "div:nth-child(3) > div:nth-child(2) > label > span")
    private WebElement selectDist;

    @FindBy(css = "input[title=\'Удаленно\']")
    private WebElement selectDistLoad;

    public void selectDist() {
        selectDist.isSelected();
        if (!selectDistLoad.isSelected()) {
            selectDist.click();
        }
    }

    @FindBy(css = "button.button_md-4:nth-child(1)")
    private WebElement savePersonalPage;

    public void savePersonalPage() {
        savePersonalPage.submit();
    }

    public void deleteContacts() {
        int i = 1;
        do {
            String s = delContacts1of2 + i + delContacts2of2;
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

    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement addButton;

    @FindBy(xpath = "//span[@class='placeholder']")
    private WebElement addContact;

    @FindBy(css = "div[class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container'] button[title='VK']")
    private WebElement vkContact;

    @FindBy(id = "id_contact-0-value")
    private WebElement vkPlace;

    @FindBy(css = "div[class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container'] button[title='OK']")
    private WebElement okContact;

    @FindBy(id = "id_contact-1-value")
    private WebElement okPlace;

    @FindBy(css = "div[class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container'] button[title='Тelegram']")
    private WebElement tlgContact;

    @FindBy(id = "id_contact-2-value")
    private WebElement tlgPlace;

    @FindBy(css = "div[class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container'] button[title='Skype']")
    private WebElement skContact;

    @FindBy(id = "id_contact-3-value")
    private WebElement skPlace;

    public void fillContacts() {
        addContact.click();
        vkContact.click();
        vkPlace.clear();
        vkPlace.sendKeys(vkString);
        addButton.click();
        addContact.click();
        okContact.click();
        okPlace.clear();
        okPlace.sendKeys(okString);
        addButton.click();
        addContact.click();
        tlgContact.click();
        tlgPlace.clear();
        tlgPlace.sendKeys(tlgString);
        addButton.click();
        addContact.click();
        skContact.click();
        skPlace.clear();
        skPlace.sendKeys(skString);
    }

    @FindBy(css = "#id_gender > option:nth-child(2)")
    private WebElement selectSexMale2;

    @FindBy(css = "#id_gender")
    private WebElement selectSexMale;

    public void selectSexMale() {
        if (!selectSexMale2.isSelected()) {
            selectSexMale.click();
            selectSexMale2.click();
        }
    }

    @FindBy(id = "id_company")
    private WebElement enterCompany;

    public void enterCompany() {
        enterCompany.clear();
        enterCompany.sendKeys(field_comp_name);
    }

    @FindBy(id = "id_work")
    private WebElement enterPosition;

    public void enterPosition() {
        enterPosition.clear();
        enterPosition.sendKeys(field_pos_name);
    }

    public void deleteExperience() {
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


    @FindBy(css = "a[title='Добавить']")
    private WebElement fieldAdd;

    @FindBy(css = "#id_experience-0-experience")
    private WebElement fieldAdd1;

    @FindBy(css = "#id_experience-0-experience > option:nth-child(3)")
    private WebElement fieldAdd1Java;

    @FindBy(css = "#id_experience-0-level > option:nth-child(2)")
    private WebElement fieldAdd1Time;

    @FindBy(css = "#id_experience-1-experience")
    private WebElement fieldAdd2;

    @FindBy(css = "#id_experience-1-experience > option:nth-child(8)")
    private WebElement fieldAdd2Perl;

    @FindBy(css = "#id_experience-1-level > option:nth-child(3)")
    private WebElement fieldAdd2Time;

    public void fillExperiences() {
        fieldAdd.click();
        fieldAdd1.click();
        fieldAdd1Java.click();
        fieldAdd1Time.click();
        fieldAdd.click();
        fieldAdd2.click();
        fieldAdd2Perl.click();
        fieldAdd2Time.click();
    }

    public static boolean isDisplayed(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
package pages;

import components.InputTextComponent;
import data.PersonalData;
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

    InputTextComponent fname;
    InputTextComponent lastname;
    InputTextComponent nameL;
    InputTextComponent lastnameL;
    InputTextComponent enterDataOfB;
    InputTextComponent enterBlogN;
    InputTextComponent enterComp;
    InputTextComponent enterPosit;


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

    public PersonalPage(WebDriver driver) {
        super(driver);
        fname = new InputTextComponent(enterFName);
        lastname = new InputTextComponent(enterLName);
        nameL = new InputTextComponent(fieldFnameLatin);
        lastnameL = new InputTextComponent(fieldLnameLatin);
        enterDataOfB = new InputTextComponent(enterDataOfBirth);
        enterBlogN = new InputTextComponent(enterBlogName);
        enterComp = new InputTextComponent(enterCompany);
        enterPosit = new InputTextComponent(enterPosition);
    }

    @FindBy(id = "id_fname")
    private WebElement enterFName;
    @FindBy(id = "id_lname")
    private WebElement enterLName;
    @FindBy(id = "id_fname_latin")
    private WebElement fieldFnameLatin;
    @FindBy(id = "id_lname_latin")
    private WebElement fieldLnameLatin;
    public void enterFName() { fname.enterText((PersonalData.FIELD_FNAME_STRING.getName())); }
    public void enterLName() { lastname.enterText(String.valueOf(PersonalData.FIELD_LNAME_STRING)); }
    public void enterFNameLatin() { nameL.enterText(String.valueOf(PersonalData.FIELD_FNAME_LATIN_STRING)); }
    public void enterLNameLatin() { lastnameL.enterText(String.valueOf(PersonalData.FIELD_LNAME_LATIN_STRING)); }

    @FindBy(name = "date_of_birth")
    private WebElement enterDataOfBirth;
    public void enterDataOfBirth() {enterDataOfB.enterText(String.valueOf(PersonalData.FIELD_DATE_OF_BIRTH_STRING)); }

    @FindBy(id = "id_blog_name")
    private WebElement enterBlogName;
    public void enterBlogName() { enterBlogN.enterText(String.valueOf(PersonalData.FIELD_ID_BLOG_NAME_STRING)); }

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
    public void selectTown() {  selectTown.click(); }

    @FindBy(css = "button[title='Санкт-Петербург']")
    private WebElement selectedSpb;
    public void selectedSpb() {  selectedSpb.click();  }

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
    public void selectFullDay() {
        selectFullDay.isSelected();
        if (!selectFullDayLoad.isSelected()) {
            selectFullDay.click();
        }
    }

    @FindBy(css = "input[title=\'Полный день\']")
    private WebElement selectFullDayLoad;
    @FindBy(css = "input[title=\'Гибкий график\']")
    private WebElement selectFlexLoad;
    @FindBy(css = "div:nth-child(2) > div:nth-child(2) > label > span")
    private WebElement selectFlex;
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
    public void enterCompany() {enterComp.enterText(String.valueOf(PersonalData.FIELD_COMP_NAME)); }

    @FindBy(id = "id_work")
    private WebElement enterPosition;
    public void enterPosition() { enterPosit.enterText(String.valueOf(PersonalData.FIELD_POS_NAME));  }

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
// проверки -
   // Assertions.assertEquals(name.getText, field_fname_string )=====================================================



}
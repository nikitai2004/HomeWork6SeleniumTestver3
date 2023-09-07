package pages;

import components.InputTextComponent;
import data.ConstantData;
import data.PersonalData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalPage extends BasePage {
    private static final Logger log = LogManager.getLogger(PersonalPage.class);

    InputTextComponent fname;
    InputTextComponent lastname;
    InputTextComponent fnameL;
    InputTextComponent lastnameL;
    InputTextComponent enterDataOfB;
    InputTextComponent enterBlogN;
    InputTextComponent enterComp;
    InputTextComponent enterPosit;

    public PersonalPage(WebDriver driver) {
        super(driver);
        fname = new InputTextComponent(enterFName);
        lastname = new InputTextComponent(enterLName);
        fnameL = new InputTextComponent(fieldFnameLatin);
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

    public void enterFName() {
        fname.enterText((PersonalData.FIELD_FNAME_STRING.getName()));
    }

    public void enterLName() {
        lastname.enterText(String.valueOf(PersonalData.FIELD_LNAME_STRING.getName()));
    }

    public void enterFNameLatin() {
        fnameL.enterText(String.valueOf(PersonalData.FIELD_FNAME_LATIN_STRING.getName()));
    }

    public void enterLNameLatin() {
        lastnameL.enterText(String.valueOf(PersonalData.FIELD_LNAME_LATIN_STRING.getName()));
    }

    @FindBy(name = "date_of_birth")
    private WebElement enterDataOfBirth;

    public void enterDataOfBirth() {
        enterDataOfB.enterText(String.valueOf(PersonalData.FIELD_DATE_OF_BIRTH_STRING.getName()));
    }

    @FindBy(id = "id_blog_name")
    private WebElement enterBlogName;

    public void enterBlogName() {
        enterBlogN.enterText(String.valueOf(PersonalData.FIELD_ID_BLOG_NAME_STRING.getName()));
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
        selectTown.click();
    }

    @FindBy(css = "button[title='Санкт-Петербург']")
    private WebElement selectedSpb;

    public void selectedSpb() {
        selectedSpb.click();
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
            String s = ConstantData.DELCONTACTS1OF2.getName() + i + ConstantData.DELCONTACTS2OF2.getName();
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
        vkPlace.sendKeys(PersonalData.VKSTRING.getName());
        addButton.click();
        addContact.click();
        okContact.click();
        okPlace.clear();
        okPlace.sendKeys(PersonalData.OKSTRING.getName());
        addButton.click();
        addContact.click();
        tlgContact.click();
        tlgPlace.clear();
        tlgPlace.sendKeys(PersonalData.TLGSTRING.getName());
        addButton.click();
        addContact.click();
        skContact.click();
        skPlace.clear();
        skPlace.sendKeys(PersonalData.SKSTRING.getName());
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
        enterComp.enterText(String.valueOf(PersonalData.FIELD_COMP_NAME.getName()));
    }

    @FindBy(id = "id_work")
    private WebElement enterPosition;

    public void enterPosition() {
        enterPosit.enterText(String.valueOf(PersonalData.FIELD_POS_NAME.getName()));
    }

    public void deleteExperience() {
        int i = 1;
        do {
            String s = ConstantData.DELEXP1OF2.getName() + i + ConstantData.DELEXP2OF2.getName();
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

    public void checkFName() {
        Assertions.assertEquals(fname.getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_FNAME_STRING.getName());
    }

    public void checkFNameLatin() {
        Assertions.assertEquals(fnameL.getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_FNAME_LATIN_STRING.getName());
    }

    public void checkLName() {
        Assertions.assertEquals(lastname.getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_LNAME_STRING.getName());
    }

    public void checkLNameLatin() {
        Assertions.assertEquals(lastnameL.getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_LNAME_LATIN_STRING.getName());
    }

    public void checkBlogName() {
        Assertions.assertEquals(enterBlogN.getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_ID_BLOG_NAME_STRING.getName());
    }

    public void checkDateOfBirth() {
        Assertions.assertEquals(enterDataOfB.getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_DATE_OF_BIRTH_STRING.getName());
    }

    public void checkCountry() {
        Assertions.assertEquals(driver.findElement(By.xpath(ConstantData.FIELD_COUNTRY.getName())).getText(), PersonalData.FIELD_RUS_STRING.getName());
    }

    public void checkTown() {
        Assertions.assertEquals(driver.findElement(By.xpath(ConstantData.FIELD_TOWN_LOAD.getName())).getText(), PersonalData.FIELD_TOWN_STRING.getName());
    }

    public void checkEngLevel() {
        Assertions.assertEquals(driver.findElement(By.xpath(ConstantData.FIELD_ENG_LEVEL.getName())).getText(), PersonalData.FIELD_ENG_LEVEL_STRING.getName());
    }

    public void checkRelocation() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(ConstantData.FIELD_RELOC_YES_LOAD.getName())).isSelected());
    }

    public void checkFullDay() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(ConstantData.FIELD_FULL_DAY_LOAD.getName())).isSelected());
    }

    public void checkFlex() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(ConstantData.FIELD_FLEX_LOAD.getName())).isSelected());
    }

    public void checkDist() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(ConstantData.FIELD_DIST_LOAD.getName())).isSelected());
    }

    public void checkEmail() {
        Assertions.assertEquals(driver.findElement(By.cssSelector(ConstantData.FIELD_EMAIL_LOAD.getName())).getAttribute(ConstantData.VAL.getName()), PersonalData.LOGIN.getName());
    }

    public void checkPhone() {
        Assertions.assertEquals(driver.findElement(By.cssSelector(ConstantData.FIELD_PHONE.getName())).getAttribute(ConstantData.VAL.getName()), PersonalData.PHONE.getName());
    }

    public void checkVK() {
        Assertions.assertTrue(PersonalData.VKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL0.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.VKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL1.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.VKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL2.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.VKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL3.getName())).getAttribute(ConstantData.VAL.getName())));
    }

    public void checkOK() {
        Assertions.assertTrue(PersonalData.OKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL0.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.OKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL1.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.OKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL2.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.OKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL3.getName())).getAttribute(ConstantData.VAL.getName())));
    }

    public void checkTlg() {
        Assertions.assertTrue(PersonalData.TLGSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL0.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.TLGSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL1.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.TLGSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL2.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.TLGSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL3.getName())).getAttribute(ConstantData.VAL.getName())));
    }

    public void checkSkype() {
        Assertions.assertTrue(PersonalData.SKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL0.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.SKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL1.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.SKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL2.getName())).getAttribute(ConstantData.VAL.getName())) || PersonalData.SKSTRING.getName().equals(driver.findElement(By.id(ConstantData.VAL3.getName())).getAttribute(ConstantData.VAL.getName())));
    }

    public void checkSex() {
        Assertions.assertEquals(ConstantData.FIELD_SM.getName(), driver.findElement(By.cssSelector(ConstantData.FIELD_S2.getName())).getAttribute(ConstantData.VAL.getName()));
        Assertions.assertTrue((driver.findElement(By.cssSelector(ConstantData.FIELD_S2.getName())).isSelected()));
    }

    public void checkCompany() {
        Assertions.assertEquals(driver.findElement(By.id(ConstantData.FIELD_COMP.getName())).getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_COMP_NAME.getName());
    }

    public void checkPos() {
        Assertions.assertEquals(driver.findElement(By.id(ConstantData.FIELD_POS.getName())).getAttribute(ConstantData.VAL.getName()), PersonalData.FIELD_POS_NAME.getName());
    }

    public void checkExperience() {
        Assertions.assertTrue(driver.findElement(By.cssSelector(ConstantData.FIELD_ADD_1_JAVA.getName())).isSelected());
        Assertions.assertEquals(PersonalData.FIELD_ADD_1_TIME_STRING.getName(), driver.findElement(By.cssSelector(ConstantData.FIELD_ADD_1_TIME.getName())).getText());
        Assertions.assertTrue(driver.findElement(By.cssSelector(ConstantData.FIELD_ADD_2_PERL.getName())).isSelected());
        Assertions.assertEquals(PersonalData.FIELD_ADD_2_TIME_STRING.getName(), driver.findElement(By.cssSelector(ConstantData.FIELD_ADD_2_TIME.getName())).getText());
    }
}
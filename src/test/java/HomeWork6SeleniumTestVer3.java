import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import settings.PropertiesReader;
import webDriverFactory.DriverManagerType;
import webDriverFactory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomeWork6SeleniumTestVer3 {
    private static final Logger log = LogManager.getLogger(HomeWork6SeleniumTestVer3.class);
    private final Map<String, String> settings = new PropertiesReader().read();
    private static WebDriver driver;

    @BeforeAll
    public static void wmSetup() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @AfterEach
    public void closeAll() {
        if (driver != null) {
            driver.close();
            driver.quit();
            log.info("Driver closed");
        }
    }

    @Test
    public void testLoginAndFillLK() {

        driver = WebDriverFactory.create(DriverManagerType.CHROME);
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("Driver started");

        // Open Otus
        driver.get(settings.get("url"));
        //new MainPage(driver).openUrl();
        new MainPage(driver).openUrl();
        new MainPage(driver).doLogIn();
        new MainPage(driver).enterLogin();
        new MainPage(driver).enterPass();
        new MainPage(driver).doCommit();

        // go to personal data page
        new BaseUserPage(driver).menuSelectClick();
        new BaseUserPage(driver).menuLkClick();

        // fill personal data
        new PersonalPage(driver).enterFName();
        new PersonalPage(driver).enterLName();
        new PersonalPage(driver).enterFNameLatin();
        new PersonalPage(driver).enterLNameLatin();
        new PersonalPage(driver).enterDataOfBirth();
        new PersonalPage(driver).selectCountry();
        new PersonalPage(driver).selectedCountryRu();
        new PersonalPage(driver).enterBlogName();
        new PersonalPage(driver).selectTown();
        new PersonalPage(driver).selectedSpb();
        new PersonalPage(driver).selectEngLevel();
        new PersonalPage(driver).selectedEngLevelAdv();
        new PersonalPage(driver).selectRelocation();
        new PersonalPage(driver).selectFullDay();
        new PersonalPage(driver).selectFlex();
        new PersonalPage(driver).selectDist();
        // del and add contacts
        new PersonalPage(driver).deleteContacts();
        new PersonalPage(driver).savePersonalPage();
        new SkillsPage(driver).gotoPersonalPage();
        new PersonalPage(driver).fillContacts();
        new PersonalPage(driver).savePersonalPage();
        new SkillsPage(driver).gotoPersonalPage();
        new PersonalPage(driver).selectSexMale();
        new PersonalPage(driver).enterCompany();
        new PersonalPage(driver).enterPosition();
        // del and add Experiences
        new PersonalPage(driver).deleteExperience();
        new PersonalPage(driver).savePersonalPage();
        new SkillsPage(driver).gotoPersonalPage();
        new PersonalPage(driver).fillExperiences();
        new PersonalPage(driver).savePersonalPage();
    }

    @Test
    public void testLoginAndCheckDataLK() {
        driver = WebDriverFactory.create(DriverManagerType.CHROME);
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("Driver started");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        BaseUserPage baseUserPage = PageFactory.initElements(driver, BaseUserPage.class);
        CheckPersonalData checkPersonalData = PageFactory.initElements(driver, CheckPersonalData.class);

        // Open Otus
 //       mainPage.openUrl();
        // Log In
        mainPage.doLogIn();
        mainPage.enterLogin();
        mainPage.enterPass();
        mainPage.doCommit();
        // go to personal data page
        baseUserPage.menuSelectClick();
        baseUserPage.menuLkClick();
        // checking personal data
        checkPersonalData.checkFName();
        checkPersonalData.checkFNameLatin();
        checkPersonalData.checkLName();
        checkPersonalData.checkLNameLatin();
        checkPersonalData.checkBlogName();
        checkPersonalData.checkDateOfBirth();
        checkPersonalData.checkCountry();
        checkPersonalData.checkTown();
        checkPersonalData.checkEngLevel();
        checkPersonalData.checkRelocation();
        checkPersonalData.checkFullDay();
        checkPersonalData.checkFlex();
        checkPersonalData.checkDist();
        checkPersonalData.checkEmail();
        checkPersonalData.checkPhone();
        checkPersonalData.checkVK();
        checkPersonalData.checkOK();
        checkPersonalData.checkTlg();
        checkPersonalData.checkSkype();
        checkPersonalData.checkSex();
        checkPersonalData.checkCompany();
        checkPersonalData.checkPos();
        checkPersonalData.checkExperience();
    }
}
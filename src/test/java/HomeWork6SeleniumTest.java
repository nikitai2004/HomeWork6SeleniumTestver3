import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webDriverFactory.DriverManagerType;
import webDriverFactory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class HomeWork6SeleniumTest {
    private static final Logger log = LogManager.getLogger(HomeWork6SeleniumTest.class);
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

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        BaseUserPage baseUserPage = PageFactory.initElements(driver, BaseUserPage.class);
        PersonalPage personalPage = PageFactory.initElements(driver, PersonalPage.class);
        SkillsPage skillsPage = PageFactory.initElements(driver, SkillsPage.class);

        // Open Otus
        mainPage.openUrl();
        // Log In
        mainPage.doLogIn();
        mainPage.enterLogin();
        mainPage.enterPass();
        mainPage.doCommit();
        // go to personal data page
        baseUserPage.menuSelectClick();
        baseUserPage.menuLkClick();
        // fill personal data
        personalPage.enterFName();
        personalPage.enterLName();
        personalPage.enterFNameLatin();
        personalPage.enterLNameLatin();
        personalPage.enterDataOfBirth();
        personalPage.selectCountry();
        personalPage.selectedCountryRu();
        personalPage.enterBlogName();
        personalPage.selectTown();
        personalPage.selectedSpb();
        personalPage.selectEngLevel();
        personalPage.selectedEngLevelAdv();
        personalPage.selectRelocation();
        personalPage.selectFullDay();
        personalPage.selectFlex();
        personalPage.selectDist();
        // del and add contacts
        personalPage.deleteContacts();
        personalPage.savePersonalPage();
        skillsPage.gotoPersonalPage();
        personalPage.fillContacts();
        personalPage.savePersonalPage();
        skillsPage.gotoPersonalPage();
        personalPage.selectSexMale();
        personalPage.enterCompany();
        personalPage.enterPosition();
        // del and add Experiences
        personalPage.deleteExperience();
        personalPage.savePersonalPage();
        skillsPage.gotoPersonalPage();
        personalPage.fillExperiences();
        personalPage.savePersonalPage();
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
        mainPage.openUrl();
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
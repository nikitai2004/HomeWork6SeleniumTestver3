import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;
import org.openqa.selenium.WebDriver;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log.info("Driver started");
        MainPage page = new MainPage(driver);
        BaseUserPage baseUserPage = new BaseUserPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);
        SkillsPage skillsPage = new SkillsPage(driver);
        // Open Otus
        driver.get(settings.get("url"));
        page.openUrl();
        page.doLogIn();
        page.enterLogin();
        page.enterPass();
        page.doCommit();
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
        MainPage page = new MainPage(driver);
        BaseUserPage baseUserPage = new BaseUserPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);
        // Open Otus
        driver.get(settings.get("url"));
        page.openUrl();
        page.doLogIn();
        page.enterLogin();
        page.enterPass();
        page.doCommit();
        // go to personal data page
        baseUserPage.menuSelectClick();
        baseUserPage.menuLkClick();
        // checking personal data
        personalPage.checkFName();
        personalPage.checkFNameLatin();
        personalPage.checkLName();
        personalPage.checkLNameLatin();
        personalPage.checkBlogName();
        personalPage.checkDateOfBirth();
        personalPage.checkCountry();
        personalPage.checkTown();
        personalPage.checkEngLevel();
        personalPage.checkRelocation();
        personalPage.checkFullDay();
        personalPage.checkFlex();
        personalPage.checkDist();
        personalPage.checkEmail();
        personalPage.checkPhone();
        personalPage.checkVK();
        personalPage.checkOK();
        personalPage.checkTlg();
        personalPage.checkSkype();
        personalPage.checkSex();
        personalPage.checkCompany();
        personalPage.checkPos();
        personalPage.checkExperience();
    }
}
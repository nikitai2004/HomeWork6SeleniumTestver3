import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomeWork5SeleniumTest {
    private final Logger log = LogManager.getLogger(HomeWork5SeleniumTest.class);
    public WebDriver driver;

    @BeforeAll
    public static void wmSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("Драйвер starting");
    }

    @AfterEach
    public void closeAll() {
        if (driver != null) {
            driver.close();
            driver.quit();
            log.info("Драйвер закрыт");
        }
    }

    @Test
    public void test01() {
        Steps.openOtus(driver);
        Steps.loginInOtus(driver);
        Steps.enterToLkab(driver);
        Steps.fillLK(driver);
    }

//    @Test
//    public void test02() {
////      Открыть https://otus.ru в "чистом браузере"
//        Steps.openOtus(driver);
////      Авторизоваться на сайте
////      Войти в личный кабинет
////      Проверить, что в разделе "О себе" отображаются указанные ранее данные
//        driver.get(Properties.url);
//    }
}


//    Шаги теста:
//
//        Открыть https://otus.ru
//        Авторизоваться на сайте
//        Войти в личный кабинет
//        В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
//        Нажать сохранить

//        Открыть https://otus.ru в "чистом браузере"
//        Авторизоваться на сайте
//        Войти в личный кабинет
//        Проверить, что в разделе "О себе" отображаются указанные ранее данные


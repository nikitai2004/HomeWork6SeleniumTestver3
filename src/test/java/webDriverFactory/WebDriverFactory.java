package webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static WebDriver create(DriverManagerType browserName) {
        switch (browserName.getDriver()) {
            case "ChromeDriver":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "FirefoxDriver":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "EdgeDriver":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                return null;
        }
    }

    public static WebDriver create(DriverManagerType browserName, MutableCapabilities wdOptions) {
        switch (browserName.getDriver()) {
            case "ChromeDriver":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) wdOptions);

            case "FirefoxDriver":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) wdOptions);
            case "EdgeDriver":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver((EdgeOptions) wdOptions);
            default:
                return null;
        }
    }
}
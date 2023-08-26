package logInSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Properties;

public class SkillsPage {
    private final WebDriver driver;

    public SkillsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoPersonalPage() {
        driver.findElement(By.xpath(Properties.field_pers_data)).click();
    }
}

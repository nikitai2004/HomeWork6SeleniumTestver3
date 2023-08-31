package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkillsPage extends BasePage{

    @FindBy(xpath = "//div[@class='nav-sidebar']//a[@title='Персональные данные']")
    private WebElement gotoPPage;

    public SkillsPage(WebDriver driver) {
        super(driver);
    }

    public void gotoPersonalPage() {gotoPPage.click();
    }
}
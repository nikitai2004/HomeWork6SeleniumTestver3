package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputTextComponent {

    WebDriver driver;
    WebElement element;

    public InputTextComponent(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public InputTextComponent(WebElement element) {
        this.element = element;
    }

    public void enterText(String fieldtext) {
        element.clear();
        element.sendKeys(fieldtext);
    }

    public String getText(){
        return element.getText();
    }

    public String getAttribute(String val) {
       return element.getAttribute(val);
    }
}
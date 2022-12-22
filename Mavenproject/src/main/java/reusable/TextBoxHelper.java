package reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxHelper {
    private static WebDriver webDriver;
    private static TextBoxHelper textBoxHelper;
    private TextBoxHelper(WebDriver driver){
        webDriver = driver;
    }
    public static TextBoxHelper getInstance(WebDriver driver){
        textBoxHelper = new TextBoxHelper(driver);

        return textBoxHelper;
    }
    public void enterTextValue(By locator, String textValue){
        webDriver.findElement(locator).sendKeys(textValue);
    }
    public String getTextValue(By locator){
        String textValue = webDriver.findElement(locator).getText();
        return textValue;
    }
    public void clearTextValue(By locator){
        webDriver.findElement(locator).clear();
    }
    public void clickTextValue(By locator){
        webDriver.findElement(locator).click();
    }
}

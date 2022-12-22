package reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper {
    private static SelectHelper selectHelper;
    private static WebDriver webDriver;
    private Select select;

    public SelectHelper(WebDriver driver){
        webDriver = driver;
    }
    public static SelectHelper getInstance(WebDriver driver){

        selectHelper = new SelectHelper(driver);
        return selectHelper;
    }
    public void selectClass(WebElement element){

        select = new Select(element);
    }
    public void selectByIndex(WebElement element,int index){
        selectClass(element);
        select.selectByIndex(index);
    }
    public void selectByValue(WebElement element,String value){
        selectClass(element);
        select.selectByValue(value);
    }
    public void selectByText(WebElement element,String text){
        selectClass(element);
        select.selectByVisibleText(text);
    }
}

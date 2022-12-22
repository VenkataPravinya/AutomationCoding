package browsercode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserCode {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","P:\\Intellipaat\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("Ravi");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("Login")).click();

        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        //Login error
        String actualErrorMessage = driver.findElement(By.id("error")).getText();
        System.out.println("Error - " + actualErrorMessage);

        if(expectedErrorMessage.equals(actualErrorMessage))
        {
            System.out.println("Both are equal");
        }
        else {
            System.out.println("Both are not equal");
        }


    }
}

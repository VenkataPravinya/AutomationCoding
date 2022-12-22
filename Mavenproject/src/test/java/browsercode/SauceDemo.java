package browsercode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","P:\\Intellipaat\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //https://www.saucedemo.com/ exercise
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();



        //Logout
        //driver.findElement(By.className("bm-burger-button")).click();
        //driver.findElement(By.id("logout_sidebar_link")).click();

    }
}

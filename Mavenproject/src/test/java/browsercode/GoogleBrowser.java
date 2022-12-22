package browsercode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","P:\\Intellipaat\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
        //WebElement element = driver.findElement(By.name("q"));
        //element.sendKeys("India");
        //element.submit();
        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();
        driver.findElement(By.name("q")).sendKeys("India" + Keys.ENTER);
        //driver.findElement(By.xpath("//input[@value='Google-søgning']")).click();


    }
}

package intellipaatexercises;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusable.BrowserInvocation;

import java.io.IOException;

public class Wiki extends BrowserInvocation {
    public static void main(String[] args) throws IOException {
        WebDriver driver = BrowserInvocation.BrowserCode();
        //String title = driver.findElement(By.cssSelector("#www-wikipedia-org > div.central-textlogo > h1 > span")).getText();
        //System.out.println("Title-" + title);
        driver.manage().window().maximize();
        driver.findElement(By.id("js-link-box-en")).click();
        //driver.close();
        String actualTitle = driver.findElement(By.id("Welcome_to_Wikipedia")).getText();
        String expectedTitle="Welcome to Wikipedia";
        if(actualTitle.equals(expectedTitle))
        {
            System.out.println("Same");
        }
    }

}

package reusable;

import io.cucumber.core.gherkin.Argument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInvocation {

    private static WebDriver driver;
    protected static WebDriver  BrowserCode() throws IOException {

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Bruger\\IdeaProjects\\Mavenproject\\src\\main\\resources\\utilities\\config.Properties"));
        Properties prop = new Properties();
        prop.load(fis);
        switch(prop.getProperty("browser")){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver","P:\\Intellipaat\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "edge" :
                System.setProperty("webdriver.edge.driver","P:\\Intellipaat\\chromedriver_win32\\edgedriver.exe");
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Pass the valid browser name");
        }
        /*if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","P:\\Intellipaat\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","P:\\Intellipaat\\chromedriver_win32\\edgedriver.exe");
            driver = new EdgeDriver();
        }
        else{
            throw new IllegalArgumentException("Pass the valid browser name");
        }*/

        driver.get(prop.getProperty("url"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;

    }
    public static int value(){
        int a=10;
        return a;
    }
    public static String stringValue(){
        String name = "LearnMore";
        return name;
    }
}

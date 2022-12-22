package stepdefinitionfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusable.BrowserInvocation;
import reusable.TextBoxHelper;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class NewSteps extends BrowserInvocation {
    private WebDriver driver;
    private TextBoxHelper textBoxHelper;
    @Given("launch URL")
    public void launchURL() throws IOException {

        driver = BrowserInvocation.BrowserCode();
        textBoxHelper = TextBoxHelper.getInstance(driver);

    }

    @When("pass Credit")
    public void passCredit() {
        textBoxHelper.enterTextValue(By.id("username"),"ravi");
        textBoxHelper.enterTextValue(By.id("password"),"123");
    }

    @And("user clicks the button")
    public void userClicksTheButton() {
        textBoxHelper.clickTextValue(By.id("Login"));
    }

    @Then("Validate error")
    public void validateError() {
        String expectedResult = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String actualResult = textBoxHelper.getTextValue(By.id("error"));

        Assert.assertEquals(expectedResult,actualResult);
    }

    @When("validate the enable condition of return date")
    public void validateTheEnableConditionOfReturnDate() {
        Boolean opacity = driver.findElement(By.id("marketDate_2")).isEnabled();
        if(opacity)
        Assert.assertTrue(opacity);
        else
            Assert.assertTrue("Disabled",opacity);

    }

    @Then("perform alert actions")
    public void performAlertActions() {
        driver.findElement(By.id("alertButton")).click();
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().accept();
    }

    @Then("click on cancel button")
    public void clickOnCancelButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        driver.switchTo().alert().dismiss();
        //String resultText = driver.findElement(By.id("confirmResult")).getText();
        //System.out.println(resultText);
    }

    @Then("click on ok button and send text {string}")
    public void clickOnOkButtonAndSendText(String text) {
        WebElement frameId = driver.findElement(By.className("GoogleCreativeContainerClass"));
        driver.switchTo().frame(frameId).close();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("promtButton")));
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    @Then("user selects date {string} and month {string}")
    public void userSelectsDate(String date, String month) {
        driver.findElement(By.className("ui-datepicker-trigger")).click();
        WebElement firstMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']"));

        //int size= firstMonth.findElements(By.className("ui-state-default")).size();
        //for(int i=0;i<size;i++){
          //  String userDate = firstMonth.findElements(By.className("ui-state-default")).get(i).getText();
           // if(userDate.equals(date))
           // {
             //   firstMonth.findElements(By.className("ui-state-default")).get(i).click();
               // break;
          //  }
        //}


        while(!((driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div")).getText()).contains(month))){

            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

        }
        List<WebElement> currentMonth = driver.findElements(By.className("ui-state-default"));
        for (WebElement e : currentMonth) {
            String uiDate = e.getText();
            if (uiDate.equals(date)) {
                e.click();
                break;
            }
        }


    }

    @Then("Handling Stale Element Exception")
    public void handlingStaleElementException() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("Aravinth");
        password.sendKeys("123");
        try {
            driver.navigate().refresh();
            username.sendKeys("Ravi");
            password.sendKeys("3434");
        }
        catch (StaleElementReferenceException e){
            username = driver.findElement(By.id("username"));
            password = driver.findElement(By.id("password"));
            username.sendKeys("Ravi");
            password.sendKeys("3434");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

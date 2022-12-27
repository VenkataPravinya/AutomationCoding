package stepdefinitionfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusable.BrowserInvocation;
import reusable.SelectHelper;
import reusable.TextBoxHelper;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.*;

public class SalesforceValidationSteps extends BrowserInvocation {

    private WebDriver driver;
    private WebElement currencyDropdownElement;
   private WebDriverWait wait;
    WebElement adultDropdownElement;
    private TextBoxHelper textBoxHelper;
    private SelectHelper selectHelper;

    int [] array;
@Given("User navigates to the Salesforce Application")
public void launchSalesforce() throws IOException {

    driver = BrowserInvocation.BrowserCode();
    textBoxHelper = TextBoxHelper.getInstance(driver);
    }
@When("User enters the username {string} and password {string}")
    public void enterUserNamePassword(String userName, String password){

    textBoxHelper.enterTextValue(By.id("username"),userName);
    textBoxHelper.enterTextValue(By.cssSelector("input[name='pw']"),password);

    //driver.findElement(By.cssSelector("#username")).sendKeys(userName);

    /*WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(100));
    driverWait.pollingEvery(Duration.ofSeconds(5));
    driverWait.ignoring(NoSuchElementException.class);
    driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='pw']")));

    driver.findElement(By.cssSelector("input[name='pw']")).sendKeys(password);*/
    //System.out.println(userName);
    //System.out.println(password);
    //driver.findElement(By.id("username")).sendKeys(userName);
    //driver.findElement(By.id("password")).sendKeys(password);

}

@And("user clicks the login button")
    public void clickLoginButton(){
    textBoxHelper.clickTextValue(By.cssSelector(".button.r4.wide.primary"));
    //driver.findElement(By.cssSelector(".button.r4.wide.primary")).click();
    //driver.findElement(By.id("Login")).click();
}

    @Then("user validates the error message")
    public void userValidatesTheErrorMessage() {
        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String actualErrorMessage = textBoxHelper.getTextValue(By.id("error"));
        //Login error
        //String actualErrorMessage = driver.findElement(By.id("error")).getText();

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage,"Doesnt match");
        
        /*if(expectedErrorMessage.equals(actualErrorMessage))
        {
            System.out.println("Both are equal");
        }
        else {
            System.out.println("Both are not equal");
        }*/
    }

    @Then("user should navigate to the homepage")
    public void userShouldNavigateToTheHomepage() {
        
    }

    @When("User enters the below details")
    public void userEntersTheBelowDetails() {
    }

    @Given("User navigates to the required URL")
    public void url() throws IOException {
        driver = BrowserInvocation.BrowserCode();
        selectHelper = SelectHelper.getInstance(driver);
    }

    @When("User selects the required value from the dropdown")
    public void selectDropdownValue() {
        currencyDropdownElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));

        selectHelper.selectByText(currencyDropdownElement,"OMR");
        //selectHelper.selectByIndex(currencyDropdownElement,2 );
        //selectHelper.selectByValue(currencyDropdownElement,"KWD");
        //old code
        //Select currencyDropdown = new Select(currencyDropdownElement) ;

        //Selecting check box family and friends
        //driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_FamilyAndFriends")).click();

        //currencyDropdown.selectByIndex(2);
        //currencyDropdown.selectByVisibleText("INR");
        //currencyDropdown.selectByValue("KWD");

        /*driver.findElement(By.xpath("//div[@class='row1 mobile-select-passengers']")).click();

        WebElement adultDropdownElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT"));
        Select adultDropdown = new Select(adultDropdownElement);
        adultDropdown.selectByValue("4");

        WebElement childDropdownElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD"));
        Select childDropdown = new Select(childDropdownElement);
        childDropdown.selectByValue("2");*/



    }

    @When("User selects the required value from the dynamic dropdown")
    public void userSelectsTheRequiredValueFromTheDynamicDropdown() {

    driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
    driver.findElement(By.xpath("//a[@value='HYD']")).click();

    driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT")).click();
    WebElement toDropdownelement = driver.findElement(By.id("glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR"));
    toDropdownelement.findElement(By.xpath("//a[@value='BLR']")).click();

    }

    @Then("iterate the dropdown values")
    public void iterateTheDropdownValues() {

        List<WebElement> options = currencyDropdownElement.findElements(By.tagName("option"));
        List<String> dropdownValues = new ArrayList<String>();
        for(WebElement output:options){
            dropdownValues.add(output.getText());

        }
        System.out.println(dropdownValues);
        for(String out:dropdownValues){
            if(out.equals("EUR"))
                Assert.assertEquals(out,"UR");
        }

        /*for(int i=0;i<currencyDropdownSize;i++){
            String value = currencyDropdownElement.findElements(By.tagName("option")).get(i).getText();
            System.out.println(value);
        }

        //
        driver.findElement(By.xpath("//div[@class='row1 mobile-select-passengers']")).click();
        adultDropdownElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT"));

        int sizeOfAdults = adultDropdownElement.findElements(By.tagName("option")).size();
        for(int j=0;j<sizeOfAdults;j++){
            String adultValue = adultDropdownElement.findElements(By.tagName("option")).get(j).getText();
            System.out.println("Values= " + adultValue);
        }
        */
    }

    @Given("login to the ACME application")
    public void loginToTheACMEApplication() throws IOException {

        driver = BrowserInvocation.BrowserCode();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    }


    @Then("add Total balance, credit balance and due today.")
    public void addTotalBalanceCreditBalanceAndDueToday() {
        String textTotalBalance = driver.findElement(By.xpath("//div[@class='balance hidden-mobile']/div[2]/span[1]")).getText();

        String subString1 = textTotalBalance.substring(1);
        int totalBalance = Integer.parseInt(subString1);
        System.out.println("Total Balance = " + totalBalance);

        String textCredit = driver.findElement(By.xpath("//div[@class='element-balances']/div[2]/div[2]")).getText();
        String subString2 = (textCredit.substring(1,3)) + (textCredit.substring(4,7));
        //int textCreditBal = Integer.parseInt(subString2);
        System.out.println("Credit Available = " + subString2);

        String textDue = driver.findElement(By.xpath("//div[@class='element-balances']/div[3]/div[2]")).getText();
        String subString3 = textDue.substring(1);
        int textDueBal = Integer.parseInt(subString3);

        System.out.println("Due Today = " + textDueBal);

    }

    @Given("Iterate from the different user names, password and click login")
    public void iterateFromTheDifferentUserNamesAndSelectPassword() {

        String userString = driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();
        String [] usernameString = userString.split("\\n");

        driver.findElement(By.id("user-name")).sendKeys(usernameString[1]);
        System.out.println(usernameString[1]);
        String passwordString = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String [] passwords = passwordString.split("\\n");

        driver.findElement(By.id("password")).sendKeys(passwords[1]);
        driver.findElement(By.id("login-button")).click();

        /*WebElement userString = driver.findElement(By.xpath("//div[@id='login_credentials']"));

        int size = userString.findElements(By.tagName("br")).size();
        System.out.println("Size = " + size);
        for(int i=0; i<size; i++){
            String users = userString.findElements(By.tagName("br")).get(i).getText();
            System.out.println(users);
        }*/


    }

    @Given("User navigates to the saucedemo application")
    public void userNavigatesToTheSaucedemoApplication() throws IOException {

    driver = BrowserInvocation.BrowserCode();
    }

    @Then("select productcontainer and iterate from drop down.")
    public void selectProductAndIterateFromDropDown() {

        WebElement productContainter = driver.findElement(By.className("product_sort_container"));
        int size = productContainter.findElements(By.tagName("option")).size();
        for(int i=0; i<size ; i++){
            String productName = productContainter.findElements(By.tagName("option")).get(i).getText();
            System.out.println(productName);
        }


    }

    @Given("User navigates to the ToolsQA application")
    public void userNavigatesToTheToolsQAApplication() throws IOException {
    driver = BrowserInvocation.BrowserCode();

    }

    @When("User handles the auto suggestive")
    public void userHandlesTheAutoSuggestive() throws InterruptedException {
        driver.findElement(By.name("flying_from_N")).click();
        WebElement from = driver.findElement(By.name("flying_from"));
        from.sendKeys("che");
        Thread.sleep(3000);
        int i=0;
        while(i<4){
            from.sendKeys(Keys.ARROW_DOWN);
            i++;
        }

        from.sendKeys(Keys.ENTER);
    }

    @When("explicit wait for 5 sec")
    public void explicitWaitForSec() {
    wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @Then("check for {string} on the screen.")
    public void checkForVisibleAfterSecondsOnTheScreen(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
        if(driver.findElement(By.id("visibleAfter")).getText().equals(text)){
            System.out.println("Text is present");
        }
        else{
            System.out.println("Text is not present");
        }
    }

    @When("switch inside the frame")
    public void switchInsideTheFrame() {

        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);

        Actions frameAction = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        frameAction.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.partialLinkText("Draggable")).click();
    }

    @When("click and hold on the user click on Baby wishlist")
    public void clickAndHoldOnTheUserClickOnBabyWishlist() {

        Actions mouseActions = new Actions(driver);
        WebElement clickElement = driver.findElement(By.className("nav-line-2 "));
        mouseActions.clickAndHold(clickElement).build().perform();
        driver.findElement(By.partialLinkText("Baby Wishlist")).click();
    }

    @When("count the links")
    public void countTheLinks() {

        int count = driver.findElements(By.tagName("a")).size();
        System.out.println("Count" + count);

        //Links in the footer section
        WebElement footerLinks = driver.findElement(By.id("footer-habitat"));
        int footerLinkSize = footerLinks.findElements(By.tagName("a")).size();
        System.out.println(footerLinkSize);

        //Products links
        List<WebElement> productsLinks = footerLinks.findElements(By.xpath("//div[@id='nav_menu-2']/ul/li/a"));
        System.out.println("Products size="+ productsLinks.size());

        for(WebElement output:productsLinks){
            String keyFunc = Keys.chord(Keys.CONTROL , Keys.ENTER);
            output.sendKeys(keyFunc);
        }

        Set<String> windowProps =  driver.getWindowHandles();
        for(String output:windowProps){
            String title = driver.switchTo().window(output).getTitle();
            System.out.println(title);
            if(title.contains("Automated App Testing")){
                driver.findElement(By.xpath("//a[@title='Features']")).click();
                break;
            }
        }
        driver.switchTo().defaultContent();



    }
}

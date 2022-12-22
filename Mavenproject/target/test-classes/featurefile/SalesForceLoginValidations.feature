Feature: Validating the login functionality of a salesforce application

  @SmokeTest @AlphaTeam
  Scenario: To Validate the login functionality with invalid user
    Given User navigates to the Salesforce Application
    When  User enters the username "ravi" and password "123"
    And user clicks the login button
    Then user validates the error message


    @RegressionTest @AlphaTeam
  Scenario:  To Validate the login functionality with valid user
    Given User navigates to the Salesforce Application
    When  User enters the username "Abs" and password "ojh"
    And user clicks the login button
    Then user should navigate to the homepage


      @PerformanceTest
  Scenario Outline:Multiple test data
    Given User navigates to the Salesforce Application
    When  User enters the username "<user name>" and password "<password>"
    And user clicks the login button
    Then user validates the error message
    Examples:
    |user name|password|
    |Ravi     |123     |
    |Divi     |345     |
    |Varshu   |567     |


  Scenario: Sign up
    Given User navigates to the Salesforce Application
    When User enters the below details
    |FirstName|LastName|Age|Mobile|
    |Aravinth |A V     |27 |3242  |
    And user clicks the login button

    @StaticDropdown
  Scenario: To handle the static dropdown
    Given User navigates to the required URL
    When  User selects the required value from the dropdown
    #Then  iterate the dropdown values

  @Dynamic
  Scenario: To handle the dynamic dropdown
    Given User navigates to the required URL
    When  User selects the required value from the dynamic dropdown

    @Autosuggestive
  Scenario: To handle the auto suggestive
    Given User navigates to the required URL
    When  User handles the auto suggestive

  @Sum
  Scenario: To add all values of an array
    Given an array with many values
    Then Add all the values of an array

  @Minimum
  Scenario: Find the Minimum number in an Array
    Given  an array with many values
    Then find the minimum number.

    @Maximum
  Scenario: Find the Maximum number in an Array
    Given an array with many values
    Then find the maximum number.

  @SecondMaximum
  Scenario: Find the second Maximum number in an Array
    Given an array with many values
    And sort an array in the increasing order
    Then find the second Maximum number.

@ACME
    Scenario: ACME login
      Given login to the ACME application
      Then add Total balance, credit balance and due today.

  @SauceDemo
  Scenario: Iterate with different users in SauceDemo app
    Given User navigates to the saucedemo application
    When  Iterate from the different user names, password and click login
    Then select productcontainer and iterate from drop down.

@ToolsQA
 Scenario:  Checking explicit wait in ToolsQa application
   Given  User navigates to the ToolsQA application
   When explicit wait for 5 sec
   Then check for "Visible After 5 Seconds" on the screen.

  @frames
  Scenario: Handle frame and mouse hover actions
    Given User navigates to the required URL
    When switch inside the frame

  @mouse
  Scenario: Mouse hover actions
    Given User navigates to the required URL
    When click and hold on the user click on Baby wishlist

  @Links
  Scenario: Link count
    Given User navigates to the required URL
    When count the links






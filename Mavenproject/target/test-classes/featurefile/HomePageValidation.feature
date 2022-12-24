Feature:Validate login
  Background:
    Given launch URL
@TT
  Scenario: Draft
    When pass Credit
    And user clicks the button
    Then Validate error

  @Enable
  Scenario: To validate enable and disable conditions
    When validate the enable condition of return date

@Alert
  Scenario: Handling of alert
    Then perform alert actions

@Confirm
  Scenario: Handling confirm box
    Then click on cancel button

@prompt
  Scenario: Handling prompt box
    Then click on ok button and send text "ravi"

@Calendar
  Scenario: Handle calendar
    Then user selects date "27" and month "April"

@Stale
  Scenario: Exceptions
    Then Handling Stale Element Exception

@Normalize
  Scenario: Handling normalize spaces
    Then click on Know more

@Cognizant
  Scenario: Getting values from Cognizant website
    Then go to Acquisitions and iterate the values under Business column

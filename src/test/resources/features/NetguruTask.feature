Feature: US_001 NetguruTask

  @wip
  Scenario Outline: Register a user
    Given user is in medunna web page
    And user clicks the registration page
    And user enters valid SSN "<ssn>"
    And user enters firstName "<firstName>"
    And user enters lastName "<lastName>"
    And user enters userName "<userName>"
    And user enters email "<email>"
    And user enters password "<firstPassword>"
    And user enters second password "<secondPassword>"
    And user clicks the register button
    And user verifies the success message as "<Message>"




    Examples:
      |ssn|firstName|lastName|userName|email|firstPassword|secondPassword|Message|
      |null|null    |null    |null    |null |null         |null          |Registration Saved|



  Scenario Outline: Sample DB validation

    Given User creates a database connection
    And User fetch all the user SSN numbers from Database "<query>" "<data>"
    Then User validates the SSN number is included among fetched data

    Examples:
      |query| data|
      |Select * from jhi_user| ssn|


  Scenario: Sample API Test

    Given Validate the info of patient named JohnDoe
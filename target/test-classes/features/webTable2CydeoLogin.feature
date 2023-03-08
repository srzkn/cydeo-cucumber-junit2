Feature: Cydeo Web Tables Application login feature
  Agile Story:
  As a user, I should be able to login and land on the page that its' url ends with "orders".

Background: user is on the login page
  Given User is on the web tables application login page

  Scenario: Login as Test (Positive login scenario)
    When user enters "Test" username
    And user enters "Tester" password
    And user clicks on Login btn
    Then user lands on a new page that its' URL ends with "orders"

  Scenario: Login as Test (Positive login scenario)
    When user enters "Test" username, "Tester" password and logins
    Then user lands on a new page that its' URL ends with "orders"


  Scenario: User should be able to see all 12 months in months dropdown
    When User enters below credentials
      | username     | Test   |
      | password     | Tester |
    Then user lands on a new page that its' URL ends with "orders"
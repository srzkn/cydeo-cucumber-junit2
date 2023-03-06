@Reg @login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts.And dashboard should be displayed.

  Accounts are: librarian, student, admin

  Background: For the scenarios in the feature file, use is expected to be on login page
    Given user is on the library login page

  @librarian @employee @wer
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

    #this is how we add comments in feature file

  @student @human
  Scenario: Login as student
      When user enters student username
      And user enters student password
      Then user should see the dashboard

      @admin
    Scenario: Login as admin
      When user enters admin username
      And  user enters admin password
      Then user should see the dashboard

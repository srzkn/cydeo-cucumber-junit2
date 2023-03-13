@wqwerty
Feature: Login 1 - Login with valid credentials

Background:
Given The user is on the login page

  Scenario: User lands on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    When  The user clicks on the Forgot your password? link
    Then the user is on the Forgot Password page

  Scenario: User should see the password in bullet signs by default (like ****)
    When  The user enters "password"
    Then the user should see the password in bullet signs

  Scenario: User can see "Remember Me" link exists and is clickable on the login page
    Then User can see Remember Me link exists and is clickable on the login page

  Scenario: Verify the ‘Enter’ key of the keyboard is working correctly on the login page.
    When The user logs in as a driver and hits enter key
    Then the user is on the Quick Launchpad page

  Scenario: Login as a driver
    When  The user logs in as a driver
    Then the user is on the Quick Launchpad page

    Scenario: Login as a Sales Manager
      When the user logs in as a Sales Manager
      Then the user is on the Dashboard page

      Scenario: : Login as a Store Manager
        When the user logs in as a Store Manager
        Then the user is on the Dashboard page

  Scenario Outline: "Please fill out this field." message is displayed if the password or username is empty
    When  The user trys to login with "<username>" and "<password>"
    Then the user can not login and "Please fill out this field." error message is displayed.

    Examples:
      | username        | password    |
      | user1           |             |
      |                 | UserUser123 |
      | storemanager51  |             |
      | salesmanager101 |             |
      |                 |             |

  Scenario Outline: All users can see their own usernames in the profile menu, after successful login
    When  The user trys to login with "<username>" and "<password>"
    Then users can see their own "<expectedName>" in the profile menu

    Examples:
      | username        | password    | expectedName    |
      | user1           | UserUser123 | user1           |
      | storemanager51  | UserUser123 | storemanager51  |
      | salesmanager101 | UserUser123 | salesmanager101 |

  Scenario Outline: User can not Login with invalid credentials
    When  The user trys to login with "<username>" and "<password>"
    Then the user can not login and (Invalid username or password) error message is displayed.

    Examples:
      | username        | password     |
      | user1           | .42^^%^^&    |
      | dasdasd         | UserUser123  |
      | storemanager51  | UserUser12   |
      | salesmanager101 | qwerty       |
      | !'^^^^&//()=    | UserUser123  |
      | %&+%&/DFSDF23   | %^^%345gdfgd |

        #given: pre-condition
        #when: action
        #then: verification / assertion

        # and
        # but

        #given: pre-condition
        #when: action
        #then: verification / assertion

        # and
        # but
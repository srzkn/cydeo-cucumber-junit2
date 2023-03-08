Feature: Wikipedia Search Functionality and verifications
  Agile story: As a user, when I am on the Wikipedia search page
  I should be able to search whatever I want and see relevant information

    #WSF-45234 --> potential jira ticket number

  Scenario: Wikipedia Search Functionality Title Verification
    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" in the wiki title

@wer
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given user is on Wikipedia home page
    When user types "<searchValue>" in the wiki search box
    And user clicks wiki search button
    Then user sees "<expectedTitle>" in the wiki title
    Then user sees "<expectedMainHeader>" in the main header

    Examples: search values we are going to be using in this scenario is as below
      | searchValue       | expectedTitle     | expectedMainHeader |
      | Kate Winslet      | Kate Winslet      | Kate Winslet       |
      | Cristiano Ronaldo | Cristiano Ronaldo | Cristiano Ronaldo  |
      | Lady Gaga         | Lady Gaga         | Lady Gaga          |
      | Bob Marley        | Bob Marley        | Bob Marley         |

  Scenario: Wikipedia Search Functionality main header Verification
    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" in the image header
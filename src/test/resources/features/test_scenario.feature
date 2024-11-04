Feature: POM Presentation

  Scenario: Search wiki article
    Given User open "https://www.google.com/" link
    When User verify page "GoogleSearchPage" is opened
    When User type text "Wiki" into field "Search Field" on page "GoogleSearchPage"
    When User click button "Search Button" on page "GoogleSearchPage"
    When User click button "The First Result" on page "GoogleSearchPage"
    Then User verify page "WikiPage" is opened

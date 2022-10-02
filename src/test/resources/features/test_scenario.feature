Feature: POM Presentation

  Scenario: Search wiki article
    Given User open "https://www.google.com/" link
    When User type text "" into field "search" on page "Google Search"
    When User click button "search button" on page "Google Search"
    Then User verify page "Wiki" is opened
    Then User verify element "y Element" is displayed on page "Wiki"

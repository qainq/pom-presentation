Feature: POM Presentation

  Scenario: Search wiki article
    Given The user opens "https://www.google.com/" link
    Then The user verifies that the page "Google Search" is opened
    When The user types the text "Page Object Model Wiki" into the field "Search Field" on the "Google Search" page
    When The user clicks the button "Search Button" on "Google Search" page
    When The user clicks the button "The First Result" on "Google Search" page
    Then The user verifies that the page "Wiki" is opened
    Then The user verifies that the element "First Header" value on the page "Wiki" is equal to "PageObject"

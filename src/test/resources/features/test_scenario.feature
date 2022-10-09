Feature: POM Presentation

  Scenario: Search wiki article
    Given The user opens "https://www.google.com/" link
    When The page Google Search is opened
    When The user types the text "Page Object Model Wiki" into the Search Field on the Google Search page
    When The user clicks the Search Button on the Google Search page
    When The user clicks the First Result button on the Google Search page
    Then The user verifies that the page Wiki is opened
    Then The user verifies that the element First Header value on the page Wiki is equal to "PageObject"

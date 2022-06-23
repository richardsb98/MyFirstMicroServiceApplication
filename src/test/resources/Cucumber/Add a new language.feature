Feature: Adding a new language into the database
  As a user I want to add a new language into the database

  Scenario: I successfully add a language into the table
    Given I have the language name and id
    When I input the language info into the database
    Then I get the success language return string
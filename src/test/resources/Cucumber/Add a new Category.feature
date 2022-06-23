Feature: Adding a new category into the database
  As a user I want to add a new category into the database

  Scenario: I successfully add a category into the table
    Given I have the category's name and id
    When I input the category info into the database
    Then I get the success category return string


Feature: Adding a new Actor
  As a user I would like to add a new actor into my table

  Scenario: I successfully add an actor into my table                           // sunny day path
    Given I have the actor information
    When I input the data into the database
    Then I get the success return string

#  Scenario: I don't have enough information                                //rainy day path
#    Given I have an actors first name
#    And I don't have their last name
#    When i try to add them into the database
#    Then I get an error message


Feature: Retrieve a film recommendation based on my preferences like category, rating, actor first name and last name, length, language, release year
  As a movie consumer, I want to find the best movie for me.
  Scenario: The user successfully gets a recommended film
    Given I have the required inputs like category, rating, actor first name and last name, length, language, release year
    When I input the required info
    Then I get a movie recommendation, based on my preferences


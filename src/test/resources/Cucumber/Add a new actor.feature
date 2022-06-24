Feature: Adding a new Actor
  As a user I would like to add a new actor into my table

  Scenario: I successfully add an actor into my table
    Given I have the actor information
    When I input the actor data into the database
    Then I get the success actor return string

#  Scenario: I don't have enough information                                rainy day path
#    Given I have an actors first name
#    And I don't have their last name
#    When i try to add them into the database
#    Then I get an error message






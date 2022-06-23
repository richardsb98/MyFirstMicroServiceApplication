Feature: Adding a new Film to the to watch list
  As a user i want to add a film to my to watch list

  Scenario: I successfully add a film into the to watch list
    Given I have the film title
    When I input the name and click the Add Movie To Watch button
    Then The film title is displayed into the list
Feature: create new DATTT
    Users can create new DATTT only if they're logged in
Scenario: The user is not logged in and tries to create a DATTT
    Given the user is not logged in
    When the user pushes the create button
    Then the user gets a failure notification
    And is redirected to the login page
    
Scenario: The user is logged in and creates a DATTT
    Given the user is logged in
    And the user has pushed the create button
    When the user enters "Mylist" as title
    And the user enters "ThingsIDontWantToForget" as content
    And the user pushes the confirm button
    Then the new DATTT is being saved
    And the new DATTT is shown to the user
    And the user gets a confirmation

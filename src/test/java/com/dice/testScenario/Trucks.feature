Feature: User can not a new truck without entering required fields
  Company description

  This feature verify scenario on Truck Page
  Scenario: User can not add a Truck without any data
    Given I was on Truck Page
    When  I click on Add button
    And I click on Confirm button
    Then Displaying error messages for missing fields
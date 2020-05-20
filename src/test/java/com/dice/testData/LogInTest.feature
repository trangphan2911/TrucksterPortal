Feature: Log In Feature
  This feature verify scenario on Log In Page
  Scenario: Login to Tiki Website
    Given I open tiki website
    And I navigate to login form
    And I enter Username and Password
      | User Name        | Password |
      | 01342479559      | 123456789 |
    And I click login button
#    Then I verify the user is logged in successfully: Dương Ngọc Thuận

#  Scenario: Login to Tiki Website22
#    Given I open tiki website
##    And I navigate to login form
#    And I enter Username and Password
#      | User Name        | Password |
#      | 01652479559      | 9540978911 |
#    And I click login button
#    Then I verify the user is logged in successfully: Dương Ngọc Thuận



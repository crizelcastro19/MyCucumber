Feature: Login

  Scenario: Login with correct username and password
    Given I want to navigate to page
    And I enter user email address as Email:admin
    And I verify the count of my salary to digits for Rs 1000
    And I enter credentials
      | username | password      |
      | admin    | admin2        |
    And I click button
    Then Success page displays
#
#  Scenario Outline: Login with Username and password to fail
#    Given I want to navigate to page
#    And I enter <userName> and <passWord> for this features
#    And I click button
#    Then Success page displays
#
#    Examples:
#      | userName   | passWord     |
#      | execute    | automation   |
#      | admin      | admin        |
#      | testing    | qa           |
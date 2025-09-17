Feature: Temperature Conversion

  Scenario: Verify Celsius to Fahrenheit conversion works correctly
    Given the app is launched
    Then the home screen is displayed
    When I enter "100" in the Celsius field
    And I tap on the Convert button
    Then I should see the Fahrenheit result "212.0"
    When I clear the Celsius field
    And I enter "0" in the Celsius field
    And I tap on the Convert button
    Then I should see the Fahrenheit result "32.0"

  Scenario: Verify Fahrenheit to Celsius conversion works correctly
    Given the app is launched
    Then the home screen is displayed
    When I enter "212" in the Fahrenheit field
    And I tap on the Convert F-C button
    Then I should see the Celsius result "100.0"
    When I clear the Fahrenheit field
    And I enter "32" in the Fahrenheit field
    And I tap on the Convert F-C button
    Then I should see the Celsius result "0.0"

  Scenario: Verify Reset button clears both fields
    Given the app is launched
    Then the home screen is displayed
    When I enter "50" in the Celsius field
    And I enter "122" in the Fahrenheit field
    And I tap on the Reset button
    Then both fields should be cleared

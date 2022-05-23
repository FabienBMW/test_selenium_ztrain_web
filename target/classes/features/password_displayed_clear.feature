@password_displayed_clear.OF-806
  Feature: As a customer I want to see my password after enter it
    Scenario:
      Given user is at login page
      When user fill in the password field "a123456"
      And User clicks on the display password button to the right of the password field
      Then The password is displayed in clear
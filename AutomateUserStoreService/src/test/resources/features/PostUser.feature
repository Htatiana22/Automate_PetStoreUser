@Stories
  Feature: Create User
    As user
    Want to create a user
    To send the information

@PostUser
  Scenario: Create user successfully
    When The user consume the endpoint  and the user sent data
    Then the user can validate the response service

@Stories
  Feature: Update User
    As user
    Want to update the data of a user
    To update the information

@UpdateUser
  Scenario: Update user information successfully
    When The user updates the basic data
    Then The user can then validate if the update was successful with the response service
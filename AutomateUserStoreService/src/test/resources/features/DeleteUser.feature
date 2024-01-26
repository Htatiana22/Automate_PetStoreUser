@Stories
  Feature: Delete User
    As user
    Want to delete a user
    To validate that it was removed successfully

@DeleteUser
  Scenario: Delete a user successfully
    When The user consumes the endpoint to delete the user
    Then The user validates the response received from the server
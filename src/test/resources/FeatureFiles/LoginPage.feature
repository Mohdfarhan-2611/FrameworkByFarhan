Feature: QKart Login Functionality

  Scenario Outline: Valid Login to QKart using valid credentials
    Given User is on QKart login page
    When User logs in with valid credentials "<valid_username>" and "<valid_password>"
    Then User should be logged in successfully

    Examples:
      | valid_username               | valid_password  |
      | mhdfarhan2611@gmail.com      | Acc0@mf#7      |

  Scenario Outline: Invalid Login to QKart using invalid credentials
    Given User is on QKart login page
    When User logs in with invalid credentials "<invalid_username>" and "<invalid_password>"
    Then User should see an error message

    Examples:
      | invalid_username  | invalid_password  |
      | invalidusername   | invalidpassword   |

Feature: Login Functionality

  Background: 
    Given user has navigated to login page

  Scenario: Login with valid credential
    When user enters valid email address "shibamohapatra153@gmail.com" into email field
    And user enters valid password "Shiba@54" into password field
    And user clicks on the  login button
    Then user should get successfully logged in

  Scenario: Login with invalid credential
    When user enters invalid email address "shiba@gmail.com" into email field
    And user enters valid password "Sh@54" into password field
    And user clicks on the  login button
    Then user should get proper warning message

  Scenario: Login with valid email id and invalid password
    When user enters invalid email address "shibamohapatra153@gmail.com" into email field
    And user enters valid password "Sh@54" into password field
    And user clicks on the  login button
    Then user should get proper warning message about credentials

  Scenario: Login with invalid email id and valid password
    When user enters invalid email address "shiba@gmail.com" into email field
    And user enters valid password "Shiba@54" into password field
    And user clicks on the  login button
    Then user should get proper warning message about credentials

  Scenario: Login without providing any credential
    When user do not enter email id into email field
    And user do not enter password into password field
    And user clicks on the login button
    Then user should get proper warning for all mandatory field

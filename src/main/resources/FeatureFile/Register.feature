Feature: Registration Functionality

  Background: 
    Given User navigates to Register Account page

  Scenario: User creates account only with mandatory fields
    When user enters the details into below fields
      | firstName | Shiba                       |
      | lastName  | Shankar                     |
      | email     | shibamohapatra15@gmail.com |
      | phone     |                  7008355173 |
      | password  | Shiba@54                    |
    And User selects Privacy Policy
    And user clicks on Continue button
    Then user account should get created successfully

  Scenario: User creates account only with all fields
    When user enters the details into below fields
      | firstName | Shiba S                       |
      | lastName  | Shankar                       |
      | email     | shibamohapatra2233@gmail.com |
      | phone     |                    7008355174 |
      | password  | Shiba@54                      |
    And user selects yes for Newsletter
    And User selects Privacy Policy
    And user clicks on Continue button
    Then user account should get created successfully

  Scenario: User creates a duplicate account
    When user enters again the details into below fields
      | firstName | Shiba                       |
      | lastName  | Shankar                     |
      | email     | shibamohapatra153@gmail.com |
      | phone     |                  7008355172 |
      | password  | Shiba@54                    |
    And user selects yes for Newsletter
    And User selects Privacy Policy
    And user clicks on Continue button
    Then user should get a proper warning about duplicate email

  Scenario: User creating account without filling any field
    When User do not enter any details into any field
    And User selects Privacy Policy
    And Clicks on continue button
    Then user should get proper warning message for every mandatory field

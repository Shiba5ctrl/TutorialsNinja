Feature: Search Functionality

Background:
Given User opens application

Scenario: User searches for a valid product
 When user enters valid product name "HP" into search box field
 And user clicks on search button
 Then user should get valid product displayed in search results
 
 Scenario: User searches for an invalid product
 When user enters invalid product name "Honda" into search box field
 And user clicks on search button
 Then user should get message no matching product
 
 Scenario: User searches without entering anything in search text field
 When user do not enter anything into search box field
 And user clicks on search button
 Then user should get proper message
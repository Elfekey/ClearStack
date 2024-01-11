	
Feature: Login
 #@FirstPart
   Scenario: Login with valid credentials
   Given User should be able to login using valid credintials "https://opensource-demo.orangehrmlive.com/"
    When User enters username as "<username>" and password as "<password>"
    And click login
    Then User should be able to see dashoboard
 #@SecondPart
   Given User should be able to see the records number
    When User click add button
    And Fill the required data and click save
    Then Verify that the number of records increased by one
 #@ThirdPart
   Given User should be able to search for users
    When Delet user
    Then Verify that the number of records decreased by one
    
       Examples:
  | username   | password | url |
  | Admin      | admin123 | https://opensource-demo.orangehrmlive.com/|

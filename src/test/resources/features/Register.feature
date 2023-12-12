Feature: Register a user

@test2
Scenario: User should register with valid Credentials

Given user is in homepage
When user clicks on login 
Then user clicks on Create New Account
And user enters phone number
Then user clicks on requestOTP

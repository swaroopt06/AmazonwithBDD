Feature: Apply Filters

@test1
Scenario:  Validate Phoneslist after applying filters

Given user is present in homepage
When user search for smartphones
And user apply filters
Then validate filtered list

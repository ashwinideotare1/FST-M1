
@createJobListing
Feature: Create a new job listing 

 ​	@createJob
  Scenario: Create a new job listing
  Given User is on Alchemy Home Page and navigates to Post a Jobs Page
  When Fill in the necessary details and click the button that says Preview. 
  And Click on the button that says Submit Listing
  Then Navigate to Jobs Page
  And Search for a submitted job and verify. 
  And Close the browser.
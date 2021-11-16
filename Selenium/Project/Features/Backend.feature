
@websiteBackend
Feature: Login into the website’s backend 

 @loginAsAdmin
  Scenario: ​Visit the site’s backend and login
  Given User is on Alchemy Admin Home Page
  When Fill in the username and password and click on login 
  Then Verify that user has logged in
  And Close the browser
  
  
  @publishJobListing
  Scenario: ​Visit the site’s backend and create a job listing
  Given User is on Alchemy Admin Home Page
  And Fill in the username and password and click on login 
  When Publish the new job listing
  Then Verify that the job listing is created
  And Close the browser
  
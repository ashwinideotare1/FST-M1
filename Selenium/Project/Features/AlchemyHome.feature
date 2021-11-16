@AlchemyHomepage
Feature: Verify the website title

  @titleVerification
  Scenario: Read the title of the website and verify the text
    Given User is on Alchemy Home Page
    When Get the title of the website
    Then It matches expected title
    And Close the browser

  @heading1
  Scenario: Read the heading of the website and verify the text
    Given User is on Alchemy Home Page
    When Get the heading of the website
    Then It matches expected heading
    And Close the browser
    
    
   @heading2
  Scenario: Read the second heading of the website and verify the text
    Given User is on Alchemy Home Page
    When Get the second heading on the page
    Then It matches expected second heading
    And Close the browser
    
	@imageUrl
  Scenario: ​Print the url of the header image to the console
    Given User is on Alchemy Home Page
    When Get the title of the website
    Then Get the url of the header image
    And Close the browser
    
    
    @navigateToJobs
    Scenario: Navigate to the “Jobs” page on the site
    Given User is on Alchemy Home Page
    When Select the menu item that says Jobs and click it
    Then Read the page title and verify that you are on the correct page
    And Close the browser
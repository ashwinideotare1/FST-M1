
@JobPageActions
Feature: Apply to a job

  @applyJob
  Scenario: Search for a job and apply for it
    Given User is on Alchemy Home Page and navigates to Jobs Page
    When Search for a particular job
    And Open any one of the jobs listed
    Then Click the apply button
    And Print the email to the console
    And Close the browser

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class AlchemyHomePage extends BaseClass {

	
	String url="https://alchemy.hguy.co/jobs";
   
    String siteDescriptionActual="";
    String siteDescriptionExpected="Job Board Application";
    
    String headingActual="";
    String headingExpected="Welcome to Alchemy Jobs";
    
    String secondHeadingActual="";
    String secondHeadingExpected="Quia quis non";
   
    
    @Given("^User is on Alchemy Home Page$")
	public void userIsOnAlchemyHomePage() {
        //Open the browser
    	initialization();
        driver.get(url);
	}
	 @When("^user logs in with \"(.*)\" and \"(.*)\"$")
	 public void user_logs_in(String username, String password) {
		 driver.findElement(By.name("Username")).sendKeys("root");
	    	driver.findElement(By.name("Password")).sendKeys("pa$$w0rd");
	    	driver.findElement(By.xpath("//button[@type='submit']")).click();
	 }
	 
	 @When("^Get the title of the website$")
	 public void getTheTitleOfTheWebsite() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='site-title']/a")));
	     System.out.println("Site Title: " + driver.getTitle());
	     siteDescriptionActual = driver.findElement(By.xpath("//*[@class='site-description']")).getText();
	     System.out.println("Site Description: " + siteDescriptionActual);
	 }
	 
	 @Then("^It matches expected title$")
	 public void verifyTheTitleAndDescription() {
		 assertEquals(siteDescriptionExpected, siteDescriptionActual);
	 }
	 
	 
	 @When("^Get the heading of the website$")
	 public void getTheHeadingOfTheWebsite() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='entry-title']")));
	     headingActual = driver.findElement(By.xpath("//*[@class='entry-title']")).getText();
	     System.out.println("Heading : " + headingActual);
	 }
	 
	 @When("^Get the second heading on the page$")
	 public void getTheSecondHeadingOfTheWebsite() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()=\"Quia quis non\"]")));
		 secondHeadingActual = driver.findElement(By.xpath("//*[text()=\"Quia quis non\"]")).getText();
	     System.out.println("Heading : " + secondHeadingActual);
	 }
	 
	 @Then("^It matches expected heading$")
	 public void verifyTheHeadingAndDescription() {
		 assertEquals(headingExpected, headingActual);
	 }
	 
	 @Then("^Get the url of the header image$")
	 public void getTheUrlOfHeaderImage() {
	     System.out.println("Header Image URL : " + driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']")).getAttribute("src"));

	 }
	  
	 @Then("^It matches expected second heading$")
	 public void verifyTheSecondHeading() {
		 assertEquals(secondHeadingExpected, secondHeadingActual);
	 }
	 
	 @When("^Select the menu item that says Jobs and click it$")
	 public void navigateToJobsPage() {
		 driver.findElement(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
	 }
	 
	 @Then("^Read the page title and verify that you are on the correct page$")
	 public void verifyPageTitle() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='entry-title']")));
	     String jobPageTitle = driver.findElement(By.xpath("//*[@class='entry-title']")).getText();
	     assertEquals("Jobs",jobPageTitle);
	 }
	 
	 @And("^Close the browser$")
	    public void closeBrowser() throws Throwable {
	        closeTheBrowser();
	    }
}

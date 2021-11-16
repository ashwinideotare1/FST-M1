package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
public class BackendPage extends BaseClass{
	
	
    String adminurl="https://alchemy.hguy.co/jobs/wp-admin";
    WebElement loginButton;
    String jobTitle= "Test job";
    
    @Given("^User is on Alchemy Admin Home Page$")
	public void userIsOnAlchemyHomePageAndNavigatesToAdminPage() {                
        //Open the browser
    	initialization();
        driver.get(adminurl);       
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("wp-submit")));

	}
   
    @And("^Fill in the username and password and click on login$")
    public void fillUserNameAndPasswordAndClickLogin() {
    	loginButton = driver.findElement(By.id("wp-submit"));
    	login();
    }
    
    
    public void login() {
    	if (loginButton.isDisplayed()) {
    		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user_login")));
    		driver.findElement(By.id("user_login")).sendKeys("root");
    		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    		driver.findElement(By.id("wp-submit")).click();
    	}else {
    		System.out.println("User has already logged in");
    	}
    		
    }
    
    
    @Then("^Verify that user has logged in$")
    public void verifyTheUserIsLoggedIn() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='wp-menu-name' and text()='Job Listings']")));
    	Assert.assertEquals(driver.findElement(By.xpath("//*[@class='wp-menu-name' and text()='Job Listings']")).isDisplayed(),true);
    }
    
    @When("^Publish the new job listing$")
    public void createNewJobListingAndPublishIt() {
    	//click on Job listing
    	driver.findElement(By.xpath("//*[@class='wp-menu-name' and text()='Job Listings']")).click();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='page-title-action' and text()='Add New']")));
    
    	//click on Add new
    	driver.findElement(By.xpath("//*[@class='page-title-action' and text()='Add New']")).click();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("post-title-0")));

    	//Fill necessary details
    	driver.findElement(By.id("post-title-0")).sendKeys("Test Job");
    	
    	//Click on publish
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Publish')]")));
    	driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Publish')]")));
    	driver.findElement(By.cssSelector("button.components-button.editor-post-publish-button.editor-post-publish-button__button.is-primary")).click();    	
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.editor-post-publish-panel__header-published")));
    	
    }
    
    @Then("^Verify that the job listing is created$")
    public void verifyJobListingIsCreated() {
		Assert.assertEquals(driver.findElement(By.cssSelector("div.editor-post-publish-panel__header-published")).isDisplayed(),true);
    
    }

}

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
public class JobsPage extends BaseClass{

    String url="https://alchemy.hguy.co/jobs";
    
    
    @Given("^User is on Alchemy Home Page and navigates to Jobs Page$")
	public void userIsOnAlchemyHomePageAndNavigatesToHomePage() {        
        //Open the browser
    	initialization();
        driver.get(url);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")));
		driver.findElement(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='entry-title']")));

	}
	
    @When("^Search for a particular job$")
    public void searchForJob() {
    	//search for job with keyword "Banking"
    	driver.findElement(By.id("search_keywords")).sendKeys("Banking");
    
    }
    
    
    @And("^Open any one of the jobs listed$")
    public void openJobsListedInTheList() {
    	//select any of the job from the list
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='job_listings']")));
		driver.findElement(By.xpath("//*[contains(@class,'job_listing type-job_listing status-publish hentry')]")).click();
    }
    
    @Then("^Click the apply button$")
    public void applyForJob() {
		//click on apply button
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='application_button button']")));
		driver.findElement(By.xpath("//*[@class='application_button button']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='job_application_email']")));
		
    }
    
    @And("^Print the email to the console$")
    public void readTheEmailId() {
    	System.out.println("Email id: "+ driver.findElement(By.xpath("//*[@class='job_application_email']")).getText());
    }


}

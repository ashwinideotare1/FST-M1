package stepDefinitions;

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
public class PostJob {

	WebDriver driver;
    WebDriverWait wait;
    String url="https://alchemy.hguy.co/jobs";
    WebElement loginButton;
    String jobTitle= "Test job";
    
    
    @Given("^User is on Alchemy Home Page and navigates to Post a Jobs Page$")
	public void userIsOnAlchemyHomePageAndNavigatesToPostJobPage() {
		//Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
                
        //Open the browser
        driver.get(url);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")));
		driver.findElement(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_title")));

	}
	
    @When("^Fill in the necessary details and click the button that says Preview$")
    public void fillTheDetailsToPostJobAndPreview() {
    	//search for job with keyword "Banking"
    	login();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_title")));
    	driver.findElement(By.id("job_title")).sendKeys(jobTitle);
    	driver.findElement(By.id("job_description_ifr")).sendKeys("This is a test job");
    	driver.findElement(By.name("submit_job"));
    }
    
    public void login() {
    	if (loginButton.isDisplayed()) {
    		loginButton.click();
    		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("Username")));
    		driver.findElement(By.name("Username")).sendKeys("root");
    		driver.findElement(By.name("Password")).sendKeys("pa$$w0rd");
    		driver.findElement(By.xpath("//button[@type='submit']")).click();
    	}else {
    		System.out.println("User has already logged in");
    	}
    		
    }
    
    @And("^Click on the button that says Submit Listing$")
    public void submitThePreviewedJobListing() {
    	//select any of the job from the list
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_preview_submit_button")));
		driver.findElement(By.id("job_preview_submit_button")).click();
    }
    
    
    @Then("^Navigate to Jobs Page$")
    public void navigateToJobsPage() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")));
    	driver.findElement(By.xpath("//*[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='entry-title']")));
    }
    
    @And("^Search for a submitted job and verify$")
    public void searchForJobAndVerifyItsDisplayed() {
    	//search for job with keyword "Banking"
    	
    	driver.findElement(By.id("search_keywords")).sendKeys(jobTitle);
    	driver.findElement(By.className("search_submit")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='job_listings']")));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='job_listings']/li/a/div/h3")).getText(),jobTitle);
    
    }

}

package ChromeActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class PopupsCard {


	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	String userName = "admin";
	String password = "password";
	String invalidPassword = "pasword";

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel_Pie");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void loginWithValidCredentials() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.training-support.net/selenium");

		//wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
    	
        // Scroll element into view and click it
	    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));     
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	    driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();
	    
	    //click on login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
	    driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();
	    
	    
        //Once the page loads, enter the credentials and login
		loginWith(userName,password);
		
		//Click on each of the tasks added to strike them out.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='action-confirmation']")));

		//Verify the welcome message
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText(),"Welcome Back, admin");
		
		
	}

	@Test
	public void loginWithInvalidCredentials() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.training-support.net/selenium");

		//wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
    	
        // Scroll element into view and click it
	    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));     
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();
		    
		    //click on login
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
		    driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();

	    
        //Once the page loads, enter the credentials and login
		loginWith(userName,invalidPassword);
		
		//Click on each of the tasks added to strike them out.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='action-confirmation']")));

		//Verify the invalid message
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText(),"Invalid Credentials");
		
		
	}
	
	public void loginWith(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='username']")));
		
		//enter username and password
		driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys(username);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys(password);

		//click on login button
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}

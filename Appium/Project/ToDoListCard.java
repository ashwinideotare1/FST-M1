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


public class ToDoListCard {


	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	String[] list = {"Add tasks to list","Get number of tasks","Clear the list"};
	
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
	public void createToDoList() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.training-support.net/selenium");

		//wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
    	
        // Scroll element into view and click it
	    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));     
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	    driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
	    
        //Once the page loads, find the input field on the page and enter the following three tasks:
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='taskInput']")));
		
		for(int i=0;i<list.length;i++) {
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(list[i]);
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		}
		
		//Click on each of the tasks added to strike them out.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='tasksList']/android.view.View")));

		List<MobileElement> taskList = (List<MobileElement>) driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		for(MobileElement element: taskList) {
			element.click();
		}
		
		//clear the list
		driver.findElementByXPath("//android.view.View[@resource-id='tasksCard']/android.view.View[2]").click();
		
		// Verify that the list is cleared.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		taskList = (List<MobileElement>) driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		Assert.assertEquals(taskList.isEmpty(), true);
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}

package GoogleKeepActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class AddNoteWithReminder {
	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;
	    String title ="Create Note";
	    String description = "Add a description as well";
	    
	    @BeforeTest
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel_Pie");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 10);
	    }

		@Test
	    public void VerifyTheNoteIsAdded() {
	    	
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       	        
	        //Click 'New note' button
	        driver.findElementById("com.google.android.keep:id/new_note_button").click();
	        
	        //Add title
	        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(title);

	        //Add description
	        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys(description);

	        //add reminder
	        driver.findElementById("com.google.android.keep:id/menu_reminder").click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.keep:id/menu_text")));
	        driver.findElementById("com.google.android.keep:id/menu_text").click();
	    	        
	        //navigate back
	        driver.findElementByAccessibilityId("Open navigation drawer").click();        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.keep:id/browse_note_interior_content")));
	        
	       //Verify the note is added 
	        Assert.assertEquals(driver.findElementById("com.google.android.keep:id/index_note_title").getText(), title);
	        Assert.assertEquals(driver.findElementById("com.google.android.keep:id/index_note_text_description").getText(), description);

	    }
	    
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}


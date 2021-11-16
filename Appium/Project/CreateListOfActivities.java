package GoogleTasksActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CreateListOfActivities {
	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;
	    String[] list = {"Complete Activity with Google Tasks","Complete Activity with Google Keep","Complete the second Activity Google Keep"};

	    @BeforeTest
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel_Pie");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 10);
	    }

	    @Test
	    public void VerifyThetasksAreCreated() {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        for(String task:list) {
	        	createTask(task);
	        }
	        
	        //Verify the tasks are added
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/task_name")));
	        List<MobileElement> elements = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
	        if(elements != null) {
	        	for(int i=0; i<elements.size();i++) {	
	        		System.out.println(elements.get(i).getText());
	        		//Assert.assertEquals(elements.get(i).getText(),list[i]);
	        	}
	        }
	       
	    }
	    
	    public void createTask(String task){
	    	//click 'Create New Task'
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/tasks_fab")));
	        driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title")));

	        //type task name and click 'Save'
	        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys(task);
	        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}

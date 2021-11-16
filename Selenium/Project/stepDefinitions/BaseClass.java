package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait ;
	 
	public BaseClass() {
		
	}
	
	public static void initialization() {		
		//initialize chrome driver
		driver = new ChromeDriver();		
		//initialize wait
		wait = new WebDriverWait(driver, 15);
	}
	
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
 
}

package Day16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Demoli.class)
public class TestExtentReports {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
	    driver = new ChromeDriver();
	    Demoli.setDriver(driver); // Pass driver to listener
	}
	
	@Test
	public void Url() {
		
		this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();		
		
		}
	@Test
	public void login() {
		
		Assert.assertEquals("Bhsnu","dbbb");
		
	}
	@Test(dependsOnMethods="login")
	public void launch() {
		

	}
	

}

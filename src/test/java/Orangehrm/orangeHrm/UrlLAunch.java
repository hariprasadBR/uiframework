package Orangehrm.orangeHrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UrlLAunch {

	@Test
	public void url() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/reg");
		
	}
}

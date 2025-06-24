package Day16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitle {
	
	WebDriver driver = new ChromeDriver();
	
	public void launchurl() {
		
		this.driver.get("https://www.facebook.com/reg");
		driver.manage().window().maximize();
		driver.getTitle();
		
		
		
	}
	

}

package Day17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Headless {
	@Test
	public void urlLaunch() {
		
		ChromeOptions options=new ChromeOptions();
		
	//	options.addArguments("--headless");
		
		//options.addArguments("--incognito");
		
	//	options.addArguments("--disable-notifications");
		
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
        System.out.println(driver.getTitle());
		
	}

}

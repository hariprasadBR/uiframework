package Day17;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink {
	@Test
	public void links() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/blog/");
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement link:links) {
			String url=link.getAttribute("href");
			try{
				URL link1 = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) link1.openConnection();
				httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
				httpURLConnection.connect();


				if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
				} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
				}
				} catch (Exception e) {
				System.out.println(url + " - " + "is a broken link");
				}
				}
				}
	
		}
		
	



package Day17;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenImage {
	@Test
	public void image() {	
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/broken_images");
			driver.manage().window().maximize();
			List<WebElement> links=driver.findElements(By.tagName("img"));
			for(WebElement link:links) {
				String url=link.getAttribute("src");
				try{
					URL link1 = new URL(url);
					URLConnection urlConnection = link1.openConnection();
					HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection ;
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



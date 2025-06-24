package Day16;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSetup {

	public static ExtentReports setup(String suitename) {
		
		ExtentReports ex=new ExtentReports();
		ExtentSparkReporter exr = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports"+"\\File"+suitename+date()+".html");
		ex.attachReporter(exr);
		return ex;
		
	}
	
	public static String date() {
		
		SimpleDateFormat dd= new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date1=dd.format(new Date());
		return date1;
	}
	public static String takescreenshot(String foldername,String methodname,WebDriver driver) {
		
		TakesScreenshot sc= (TakesScreenshot)driver;
		File src=sc.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\"+foldername+"\\"+methodname+date()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
		
		
		
		
	}
	
}

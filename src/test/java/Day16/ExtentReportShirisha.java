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

public class ExtentReportShirisha {
	
	static WebDriver driver;
	
public static ExtentReports setup(String suitname) {
	ExtentReports ex = new ExtentReports();
	ExtentSparkReporter exr = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\Reports\\"+suitname+date()+".html");
	ex.attachReporter(exr);	
	return ex;	
	}
public static String screenshot(String screenshotname) throws IOException {
	TakesScreenshot sc = (TakesScreenshot)driver;
	File file = sc.getScreenshotAs(OutputType.FILE);
	File source = new File(System.getProperty("user.dir")+"\\src\\Screenshots\\"+screenshotname+date()+".png");
	FileUtils.copyFile(file, source);
	return source.getAbsolutePath();
	
}
public static String date() {
	SimpleDateFormat dd=new SimpleDateFormat("ddMMyyyy_HHmmss");
	String date = dd.format(new Date());
	return date;
}

}

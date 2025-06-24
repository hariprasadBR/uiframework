package Day16;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Demoli extends ExtentReportSetup implements ITestListener{

	ExtentReports report;
	ExtentTest extenttest;
	static WebDriver driver; // Make it static if needed to access from test class

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }
	
	@Override
	public void onTestStart(ITestResult result) {

		this.extenttest=this.report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		this.extenttest.log(Status.PASS, result.getMethod().getMethodName());
		this.extenttest.addScreenCaptureFromPath(ExtentReportSetup.takescreenshot("Screenshot", result.getMethod().getMethodName(),this.driver ));
		

	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.extenttest.log(Status.FAIL, result.getMethod().getMethodName());
		this.extenttest.addScreenCaptureFromPath(ExtentReportSetup.takescreenshot("Screenshot", result.getMethod().getMethodName(),this.driver ));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.extenttest.log(Status.SKIP, result.getMethod().getMethodName());
		this.extenttest.addScreenCaptureFromPath(ExtentReportSetup.takescreenshot("Screenshot", result.getMethod().getMethodName(),this.driver ));
	}

	
	@Override
	public void onStart(ITestContext context) {

		this.report=ExtentReportSetup.setup(context.getSuite().getName());
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		this.report.flush();
	}

	
	
	
}

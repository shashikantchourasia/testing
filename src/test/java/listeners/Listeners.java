package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReports.ExtentReportSparkerClass;

public class Listeners implements ITestListener {
	ExtentTest test;
	public static ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	String testName;
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		testName =  result.getMethod().getMethodName();
		report=ExtentReportSparkerClass.getExtentReports();
		test=report.createTest(testName);
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		thread.get().log(Status.PASS,"the test "+testName+" got passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		thread.get().fail(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}

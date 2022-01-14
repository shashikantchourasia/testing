package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSparkerClass {

	public static ExtentReports getExtentReports() {
		String path = System.getProperty("user.dir") + "\\extentReports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("ATB Financials");
		report.config().setReportName("Login in Report Details");
		
		ExtentReports re = new ExtentReports();
		re.attachReporter(report);
		
		return re;

	}

}

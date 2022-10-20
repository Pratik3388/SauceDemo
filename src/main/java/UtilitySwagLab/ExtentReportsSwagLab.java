package UtilitySwagLab;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsSwagLab {
	
	public static ExtentReports reportGenrationSwagLab()
	{
		ExtentSparkReporter extent1 = new ExtentSparkReporter("SwagLabReport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(extent1);
		report.setSystemInfo("ReportGenrater", "Pratik J");
		report.setSystemInfo("Report Name", "Regration");
		report.setSystemInfo("Suit Name", "SwagLab");
		return report;
	}
}

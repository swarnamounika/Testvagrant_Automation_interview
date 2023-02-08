package com.testvagrant.interview.RC_Banglore;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportGeneration {
	public static ExtentReports erep = new ExtentReports();

	public static ExtentReports extentReportGenerator() {
		String path = "D:\\interview\\RC_Banglore\\ExtentReports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("TestCase Status");
		report.config().setDocumentTitle("Report");
		erep.attachReporter(report);
		return erep;
	}
}

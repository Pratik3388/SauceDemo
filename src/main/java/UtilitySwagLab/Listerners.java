package UtilitySwagLab;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import pojo.DriverClass;

public class Listerners extends DriverClass implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Successfull " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		try {
			SwagScreenShot.SS(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Test is Failed " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped " + result.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Start test Successfully " + result.getName());
	}
}

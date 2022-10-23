package TestCasesSwagLab;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.SwagLoginPage;
import UtilitySwagLab.ExtentReportsSwagLab;
import pojo.DriverClass;
import pojo.OpenChrome;

@Listeners(UtilitySwagLab.Listerners.class)
public class LoginWtihStanderedUser extends DriverClass {
	
	ExtentReports report1;
	ExtentTest test;
	
	@BeforeTest
	public void reportLunch()
	{
		report1 = ExtentReportsSwagLab.reportGenrationSwagLab();
	}
	
	@BeforeMethod
	public void openChromeTest()
	{
		driver = OpenChrome.ChromeB();
	}
	
	@DataProvider (name = "dataInput")
	public Object[][] data()
	{
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
	}
	
	@Test (dataProvider = "dataInput")
	public void withStanderedUserID(String name, String pass) throws EncryptedDocumentException, IOException
	{
		test = report1.createTest("withStanderedUserID");
		SwagLoginPage logIn = new SwagLoginPage(driver);
		logIn.enterUserId(name);
		logIn.enterPass(pass);
		logIn.clickLogin();
		String expectedResult = "https://www.saucedemo.com/inventory.html";
		String actuleResult = driver.getCurrentUrl();
		Assert.assertEquals(actuleResult, expectedResult, "Fail");
	}
	@Test (dataProvider = "dataInput")
	public void getTextError(String name, String pass) throws EncryptedDocumentException, IOException
	{
		test = report1.createTest("getTextError");
		SwagLoginPage logIn = new SwagLoginPage(driver);
		logIn.enterUserId(name);
		logIn.enterPass(pass);
		logIn.clickLogin();
		String error = logIn.getErrorMSG();
		System.out.println(error);
		String expectedResult = "Epic sadface: Sorry, this user has been locked out.";
		Assert.assertEquals(error, expectedResult, "Pass");
	}
	@AfterMethod
	public void report_status(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void fushReport()
	{
		report1.flush();
	}
}
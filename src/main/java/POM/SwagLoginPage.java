package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitySwagLab.ExpliciteWaitTill;
import UtilitySwagLab.UserIdData;
import pojo.DriverClass;

public class SwagLoginPage extends DriverClass {

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement userId;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pass;
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement logIn;
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMSG;
	@FindBy(xpath = "//h4[normalize-space()='Accepted usernames are:']")
	private WebElement Data;

	public SwagLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(int row, int cell) throws EncryptedDocumentException, IOException {
		ExpliciteWaitTill.waitTill(userId);
		userId.sendKeys(UserIdData.Para(row, cell, "DataSwagLab"));
	}

	public void enterPass(int row,int cell) throws EncryptedDocumentException, IOException {
		ExpliciteWaitTill.waitTill(pass);
		pass.sendKeys(UserIdData.Para(row,cell, "DataSwagLab"));
	}

	public void clickLogin() {
		logIn.click();
	}
	public String getErrorMSG() {
		ExpliciteWaitTill.waitTill(errorMSG);
		String error1 = errorMSG.getText();
		return error1;
	}
	
	public String getDataText() {
		String data1 = Data.getText();
		return data1;
	}
}
package UtilitySwagLab;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class SwagScreenShot {
	
	public static void SS(WebDriver driver,String k) throws IOException
	{
		TakesScreenshot g = (TakesScreenshot)driver;
		File Src = g.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\pjagd\\eclipse-workspace\\SWAGLAB\\ScreenShotSwag\\"+k+".png");
		FileHandler.copy(Src, destination);
	}
}
package ScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotClass {
	
	WebDriver driver;

	public ScreenshotClass(WebDriver driver) {
		this.driver = driver;
	}

	public void ScreenShots(String ScreenshotName) throws IOException 
	{

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFileDestFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + ScreenshotName + ".png");

		FileUtils.copyFile(SrcFile, DestFileDestFile);

	}
}

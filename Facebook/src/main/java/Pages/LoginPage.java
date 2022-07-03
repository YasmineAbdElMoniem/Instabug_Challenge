package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	String URL = "https://www.facebook.com/login/";

	By UsernameText = By.xpath("//input[@name='email']");

	By Password = By.xpath("//input[@name='pass']");

	By SignInButton = By.xpath("//button[@name='login']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Navigate() {
		driver.navigate().to(URL);

	}

	public void EnterCredientials(String Username, String Pass) {
		driver.findElement(UsernameText).sendKeys(Username);
		driver.findElement(Password).sendKeys(Pass);

	}

	public void ClickOnSignInButton() {
		driver.findElement(SignInButton).click();

	}

	public void ScreenShots(String ScreenshotName) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFileDestFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + ScreenshotName + ".png");

		FileUtils.copyFile(SrcFile, DestFileDestFile);

	}
}

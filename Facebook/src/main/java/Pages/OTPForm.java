package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OTPForm {

	WebDriver driver;

	By OtpForm = By.xpath("//h2[@class='uiHeaderTitle']");

	public OTPForm(WebDriver driver) {
		this.driver = driver;
	}

	public boolean CheckThatOtpFormIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(OtpForm));

		return driver.findElement(OtpForm).isDisplayed();
	}

	public void ScreenShots(String ScreenshotName) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFileDestFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + ScreenshotName + ".png");

		FileUtils.copyFile(SrcFile, DestFileDestFile);

	}
}

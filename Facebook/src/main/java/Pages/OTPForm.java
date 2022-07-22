package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
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

}

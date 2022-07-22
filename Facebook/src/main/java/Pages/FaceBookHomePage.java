package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookHomePage {

	WebDriver driver;

	By WelcomeOnFacebook = By.xpath("//div[@class='bcvklqu9 nzypyw8j']");

	public FaceBookHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String WelconFaceBook() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WelcomeOnFacebook));

		return driver.findElement(WelcomeOnFacebook).getText();

	}
}
